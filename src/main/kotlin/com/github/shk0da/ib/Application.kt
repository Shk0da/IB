package com.github.shk0da.ib

import org.slf4j.LoggerFactory

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

        val summary = client.getAccountSummary("TotalCashBalance")
        log.info("summary: {}", summary)

        val tickers = client.findAllTickersByName("VOO")
        log.info("tickers: {}", tickers)
    }
}

