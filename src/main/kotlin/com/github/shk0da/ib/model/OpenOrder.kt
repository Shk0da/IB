package com.github.shk0da.ib.model

import com.ib.client.Contract
import com.ib.client.Order
import com.ib.client.OrderState

data class OpenOrder(val orderId: Int, val contract: Contract?, val order: Order?, val orderState: OrderState?) {
    override fun toString(): String {
        return "OpenOrder(" +
                "orderId=$orderId, " +
                "action=${order?.action()}, " +
                "totalQuantity=${order?.totalQuantity()}, " +
                "contractId=${contract?.conid()}, " +
                "symbol=${contract?.symbol()}, " +
                "secType=${contract?.secType()}, " +
                "exchange=${contract?.exchange()}, " +
                "currency=${contract?.currency()}, " +
                "localSymbol=${contract?.localSymbol()}, " +
                "tradingClass=${contract?.tradingClass()}, " +
                "lmtPrice=${order?.lmtPrice()}, " +
                "auxPrice=${order?.auxPrice()}, " +
                "TIF=${order?.tif()}, " +
                "openClose=${order?.openClose()}, " +
                "origin=${order?.origin()}, " +
                "clientId=${order?.clientId()}, " +
                "parentId=${order?.parentId()}, " +
                "permId=${order?.permId()}, " +
                "discretionaryAmt=${order?.discretionaryAmt()}, " +
                "triggerMethod=${order?.triggerMethod()}, " +
                "ocaType=${order?.ocaType()}, " +
                "trailStopPrice=${order?.trailStopPrice()}, " +
                "account=${order?.account()}, " +
                "clearingIntent=${order?.clearingIntent()}, " +
                "parentPermId=${order?.parentPermId()}, " +
                "status=${orderState?.status()}, " +
                ")"
    }
}