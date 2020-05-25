package com.github.shk0da.ib.model

import com.ib.client.Contract
import com.ib.client.Types

data class Ticker(
    val id: Int,
    val symbol: String,
    val secType: Types.SecType,
    val exchange: String,
    val currency: String,
    val derivativeSecTypes: List<String>
) {
    fun toContract(): Contract {
        val contract = Contract()
        contract.conid(id)
        contract.symbol(symbol)
        contract.secType(secType)
        contract.currency(currency)
        contract.exchange(if (exchange == "NASDAQ.NMS") "ISLAND" else exchange) // IB wtf?
        return contract
    }
}