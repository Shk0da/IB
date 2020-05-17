package com.github.shk0da.ib.model

import com.ib.client.TickAttribBidAsk
import com.ib.client.TickAttribLast

data class TickData(
    val time: Long,
    val bidPrice: Double? = null,
    val askPrice: Double? = null,
    val bidSize: Int? = null,
    val askSize: Int? = null,
    val midPoint: Double? = null,
    val price: Double? = null,
    val size: Int? = null,
    val tickType: Int? = null,
    val tickAttribBidAsk: TickAttribBidAsk? = null,
    val tickAttribLast: TickAttribLast? = null,
    val exchange: String? = null,
    val specialConditions: String? = null
)