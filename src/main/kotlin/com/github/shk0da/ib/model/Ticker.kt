package com.github.shk0da.ib.model

import com.ib.client.Types

data class Ticker(
    val id: Int,
    val symbol: String,
    val secType: Types.SecType,
    val exchange: String,
    val currency: String,
    val derivativeSecTypes: List<String>
)