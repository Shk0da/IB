package com.github.shk0da.ib

import com.github.shk0da.ib.model.AccountSummary
import com.github.shk0da.ib.model.Ticker
import com.ib.client.EClientSocket
import com.ib.client.EJavaSignal
import com.ib.client.EReader
import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import javax.swing.SwingUtilities

class IBClient(host: String, port: Int, clientId: Int) {

    private val log = LoggerFactory.getLogger(IBClient::class.java)

    private val maxMessages = 1_000_000
    private val messageCounter: AtomicInteger = AtomicInteger(0)

    private val signal = EJavaSignal()
    private val client = EClientSocket(IBWrapper(this), signal)

    private val requestSetQueue = HashSet<Int>()
    private val requestMapQueue = ConcurrentHashMap<Int, Any?>()

    init {
        connect(host, port, clientId)
        attachDisconnectHook(this)
    }

    fun nextReqId(): Int {
        return messageCounter.get() + 1;
    }

    fun socket(): EClientSocket {
        return client
    }

    fun requestGetValue(reqId: Int): Any? {
        return requestMapQueue[reqId]
    }

    fun requestSetValue(reqId: Int, value: Any?) {
        requestMapQueue[reqId] = value
    }

    fun requestEnd(reqId: Int) {
        requestSetQueue.add(reqId)
    }

    fun serverVersion(): Int {
        return client.serverVersion()
    }

    fun getAccountSummaryList(): List<AccountSummary>? {
        val reqId = reqId()
        client.reqAccountSummary(reqId, "All", "\$LEDGER:USD")
        return getRequestResult(reqId) as List<AccountSummary>?
    }

    fun getAccountSummary(tag: String): AccountSummary? {
        val summary = getAccountSummaryList()
        summary?.forEach { if (it.tag == tag) return it }
        return null
    }

    fun findAllTickersByName(name: String): List<Ticker>? {
        val reqId = reqId()
        client.reqMatchingSymbols(reqId, name)
        return getRequestResult(reqId) as List<Ticker>?
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
        log.info("Connected: $host:$port [$clientId]")
        Thread(Runnable {
            while (client.isConnected) {
                signal.waitForSignal()
                try {
                    SwingUtilities.invokeAndWait {
                        try {
                            reader.processMsgs()
                        } catch (e: IOException) {
                            error(e)
                        }
                    }
                } catch (e: java.lang.Exception) {
                    error(e)
                }
            }
        }).start()
    }

    private fun attachDisconnectHook(ibClient: IBClient) {
        Runtime.getRuntime().addShutdownHook(Thread(Runnable { ibClient.client.eDisconnect() }))
    }

    private fun reqId(): Int {
        if (messageCounter.incrementAndGet() == maxMessages) {
            messageCounter.set(1)
        }
        return messageCounter.toInt()
    }
}