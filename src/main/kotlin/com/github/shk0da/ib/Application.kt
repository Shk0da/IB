package com.github.shk0da.ib

import com.github.shk0da.ib.client.IBClient
import com.github.shk0da.ib.model.Position
import com.github.shk0da.ib.model.TickType
import com.ib.client.Contract
import com.ib.client.Order
import org.slf4j.LoggerFactory
import kotlin.math.abs
import kotlin.math.round

class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application().run()
        }
    }

    fun run() {
        val client = IBClient("localhost", 7497, 100)
        log.info("ServerVersion: {}", client.serverVersion())

        val summary = client.accountSummary("TotalCashBalance")
        log.info("summary: {}", summary)

        client.cancelAllOrders()
        val openOrders = client.allOpenOrders()
        log.info("open orders: {}", openOrders)

        val tickers = client.findAllTickersByName("VOO")
        log.info("tickers: {}", tickers)

        val ibkrTicker = Contract()
        ibkrTicker.symbol("IBKR")
        ibkrTicker.secType("STK")
        ibkrTicker.currency("USD")
        ibkrTicker.exchange("ISLAND")

        val ibkrTickerDetails = client.contractDetails(ibkrTicker)
        log.info("ibkrTickerDetails: {}", ibkrTickerDetails.contract().description())

        val daxIndex = Contract()
        daxIndex.symbol("DAX")
        daxIndex.secType("IND")
        daxIndex.currency("EUR")
        daxIndex.exchange("DTB")

        val daxIndexDetails = client.contractDetails(daxIndex)
        log.info("daxIndexDetails: {}", daxIndexDetails.contract().description())

        val ibmSmart = Contract()
        ibmSmart.symbol("IBM")
        ibmSmart.secType("STK")
        ibmSmart.currency("USD")
        ibmSmart.exchange("SMART")

        val ibmSmartTickByTickData = client.tickByTickData(ibmSmart, TickType.AllLast, 0, false)
        log.info("ibmSmartTickByTickData: {}", ibmSmartTickByTickData)

        val order = Order()
        order.action("BUY")
        order.orderType("MIT")
        order.totalQuantity(1.0)
        order.auxPrice(50.0)

        val placedOrder = client.placeOrder(ibkrTicker, order)
        log.info("placedOrder: {}", placedOrder)
        log.info("open orders: {}", client.allOpenOrders())

        if (null != placedOrder) {
            client.cancelOrder(placedOrder.orderId)
        }
        log.info("open orders: {}", client.allOpenOrders())

        val positions: List<Position> = client.positions()
        log.info("positions: {}", positions)

        val totalCache = client.accountSummary("TotalCashBalance")!!.value.toDouble()
        for (it in mapOf(Pair("ADTN", 0.2), Pair("PZZA", 0.2), Pair("MSCI", 0.2))) {
            val allTickersByName = client.findAllTickersByName(it.key).filter { ticker ->
                ticker.secType.name == "STK" && ticker.currency == "USD"
            }.toList()

            if (allTickersByName.isEmpty()) {
                log.warn("Symbol '{}' not found", it.key)
                continue
            }

            val ticker = allTickersByName.first()
            log.info("ticker: {}", ticker)

            val contract = ticker.toContract()

            val price = 10.0
            val qtyToOrder = round((totalCache * it.value) / price)
            val action = if (qtyToOrder > 0) "BUY" else "SELL"
            log.info("{} {} '{}' by {}$", action, abs(qtyToOrder), it.key, price)

            val tickerOrder = Order()
            tickerOrder.action(action)
            tickerOrder.orderType("LMT")
            tickerOrder.totalQuantity(qtyToOrder)
            tickerOrder.auxPrice(price)
            tickerOrder.lmtPrice(price)

            client.placeOrder(contract, tickerOrder)
        }

        // check positions
        client.allOpenOrders().forEach {
            log.info("order: {}", it)
        }
        Thread.sleep(5000)
        client.positions().forEach {
            log.info("position: {}", it)
        }

        client.cancelAllOrders()

        log.info("Done")
    }
}
