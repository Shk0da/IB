package com.github.shk0da.ib.client

import com.github.shk0da.ib.model.*
import com.github.shk0da.ib.model.TickType
import com.ib.client.*
import org.slf4j.LoggerFactory
import java.io.IOException
import java.lang.Thread.sleep
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

class IBClient(host: String, port: Int, clientId: Int) {

    private val log = LoggerFactory.getLogger(IBClient::class.java)

    private val maxMessages = Int.MAX_VALUE
    private val orderCounter: AtomicInteger = AtomicInteger(-1)
    private val messageCounter: AtomicInteger = AtomicInteger(0)

    private val signal = EJavaSignal()
    private val client = EClientSocket(IBWrapper(this), signal)

    private val requestSetQueue = HashSet<Int>()
    private val requestMapQueue = ConcurrentHashMap<Int, Any?>()

    init {
        connect(host, port, clientId)
        attachDisconnectHook(this)
    }

    internal fun nextOrderId(): Int {
        return orderCounter.get()
    }

    internal fun setNextOrderId(nextId: Int) {
        orderCounter.set(nextId)
    }

    internal fun requestGetValue(reqId: Int): Any? {
        return requestMapQueue[reqId]
    }

    internal fun requestEnd(reqId: Int) {
        requestSetQueue.add(reqId)
    }

    internal fun requestSetValue(reqId: Int, value: Any?) {
        requestMapQueue[reqId] = value
    }

    fun socket(): EClientSocket {
        return client
    }

    fun serverVersion(): Int {
        return client.serverVersion()
    }

    fun accountSummaryList(): List<AccountSummary> {
        val reqId = reqId()
        client.reqAccountSummary(reqId, "All", "\$LEDGER:USD")
        return getRequestResult(reqId) as List<AccountSummary>
    }

    fun accountSummary(tag: String): AccountSummary? {
        val summary = accountSummaryList()
        summary.forEach { if (it.tag == tag) return it }
        return null
    }

    fun findAllTickersByName(name: String): List<Ticker> {
        val reqId = reqId()
        client.reqMatchingSymbols(reqId, name)
        return getRequestResult(reqId) as List<Ticker>
    }

    fun contractDetails(contract: Contract): ContractDetails {
        val reqId = reqId()
        client.reqContractDetails(reqId, contract)
        return getRequestResult(reqId) as ContractDetails
    }

    fun tickByTickData(contract: Contract, tickType: TickType, numberOfTicks: Int, ignoreSize: Boolean): TickData? {
        val reqId = reqId()
        client.reqTickByTickData(reqId, contract, tickType.name, numberOfTicks, ignoreSize)
        return getRequestResult(reqId) as TickData?
    }

    fun placeOrder(contract: Contract, order: Order): OpenOrder? {
        val orderId = nextOrderId()
        client.placeOrder(orderId, contract, order)
        while (!requestSetQueue.contains(orderId)) {
            allOpenOrders().forEach {
                if (it.orderId == orderId) return it
            }
            sleep(500)
        }
        return getRequestResult(orderId) as OpenOrder?
    }

    fun cancelOrder(orderId: Int) {
        client.cancelOrder(orderId)
        while (!requestSetQueue.remove(orderId));
    }

    fun cancelAllOrders() {
        client.reqGlobalCancel()
        while (allOpenOrders().isNotEmpty());
    }

    fun allOpenOrders(): List<OpenOrder> {
        client.reqAllOpenOrders()
        return getRequestResult(nextOrderId()) as List<OpenOrder>? ?: ArrayList()
    }

    private fun getRequestResult(reqId: Int): Any? {
        while (!requestSetQueue.contains(reqId));
        requestSetQueue.remove(reqId)
        return requestMapQueue.remove(reqId)
    }

    private fun connect(host: String, port: Int, clientId: Int) {
        client.eConnect(host, port, clientId)
        val reader = EReader(client, signal)
        reader.start()
        Thread(Runnable {
            while (client.isConnected) {
                signal.waitForSignal()
                try {
                    reader.processMsgs()
                } catch (e: IOException) {
                    log.error("{}", e.message, e)
                    error(e)
                }
            }
        }).start()
        log.info("Connected: $host:$port [$clientId]")
    }

    private fun attachDisconnectHook(ibClient: IBClient) {
        Runtime.getRuntime().addShutdownHook(Thread(Runnable { ibClient.client.eDisconnect() }))
    }

    private fun reqId(): Int {
        if (messageCounter.incrementAndGet() == maxMessages) {
            messageCounter.set(1)
        }
        return messageCounter.get()
    }
}