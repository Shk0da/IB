package com.github.shk0da.ib.model

import com.ib.client.Contract

data class Position (val account: String, val contract: Contract, val position: Double, val avgCost: Double) {
    override fun toString(): String {
        return "Position(" +
                "Account='$account', " +
                "Symbol=${contract.symbol()}, " +
                "SecType=${contract.secType()}, " +
                "Currency=${contract.currency()}, " +
                "Position=$position, " +
                "Avg cost=$avgCost" +
                ")"
    }
}