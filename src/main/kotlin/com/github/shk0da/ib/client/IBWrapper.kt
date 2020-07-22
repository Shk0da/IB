package com.github.shk0da.ib.client

import com.github.shk0da.ib.model.*
import com.ib.client.*
import org.slf4j.LoggerFactory

internal class IBWrapper(private val ibClient: IBClient) : EWrapper {

    private val log = LoggerFactory.getLogger(IBWrapper::class.java)

    private val skipErrorCodes: Map<Int, String> = mapOf(
        Pair(10167, "Requested market data is not subscribed. Displaying delayed market data...")
    )

    override fun historicalData(p0: Int, p1: Bar?) {
        log.trace("Not yet implemented: historicalData")
    }

    override fun rerouteMktDepthReq(p0: Int, p1: Int, p2: String?) {
        log.trace("Not yet implemented: rerouteMktDepthReq")
    }

    override fun mktDepthExchanges(p0: Array<out DepthMktDataDescription>?) {
        log.trace("Not yet implemented: mktDepthExchanges")
    }

    override fun histogramData(p0: Int, p1: MutableList<HistogramEntry>?) {
        log.trace("Not yet implemented: histogramData")
    }

    override fun tickNews(p0: Int, p1: Long, p2: String?, p3: String?, p4: String?, p5: String?) {
        log.trace("Not yet implemented: tickNews")
    }

    override fun updateAccountTime(p0: String?) {
        log.trace("Not yet implemented: updateAccountTime")
    }

    override fun verifyAndAuthMessageAPI(p0: String?, p1: String?) {
        log.trace("Not yet implemented: verifyAndAuthMessageAPI")
    }

    override fun newsProviders(p0: Array<out NewsProvider>?) {
        log.trace("Not yet implemented: newsProviders")
    }

    override fun updateNewsBulletin(p0: Int, p1: Int, p2: String?, p3: String?) {
        log.trace("Not yet implemented: updateNewsBulletin")
    }

    override fun tickOptionComputation(
        p0: Int,
        p1: Int,
        p2: Double,
        p3: Double,
        p4: Double,
        p5: Double,
        p6: Double,
        p7: Double,
        p8: Double,
        p9: Double
    ) {
        log.trace("Not yet implemented: tickOptionComputation")
    }

    override fun scannerParameters(p0: String?) {
        log.trace("Not yet implemented: scannerParameters")
    }

    override fun scannerDataEnd(p0: Int) {
        log.debug("scannerDataEnd: scannerDataEnd")
    }

    override fun verifyMessageAPI(p0: String?) {
        log.trace("Not yet implemented: verifyMessageAPI")
    }

    override fun positionMulti(p0: Int, p1: String?, p2: String?, p3: Contract?, p4: Double, p5: Double) {
        log.trace("Not yet implemented: positionMulti")
    }

    override fun completedOrder(p0: Contract?, p1: Order?, p2: OrderState?) {
        log.trace("Not yet implemented: completedOrder")
    }

    override fun connectAck() {
        ibClient.socket().startAPI()
    }

    override fun updateMktDepthL2(
        p0: Int,
        p1: Int,
        p2: String?,
        p3: Int,
        p4: Int,
        p5: Double,
        p6: Int,
        p7: Boolean
    ) {
        log.trace("Not yet implemented: updateMktDepthL2")
    }

    override fun receiveFA(p0: Int, p1: String?) {
        log.trace("Not yet implemented: receiveFA")
    }

    override fun historicalTicksBidAsk(p0: Int, p1: MutableList<HistoricalTickBidAsk>?, p2: Boolean) {
        log.trace("Not yet implemented: historicalTicksBidAsk")
    }

    override fun historicalNews(p0: Int, p1: String?, p2: String?, p3: String?, p4: String?) {
        log.trace("Not yet implemented: historicalNews")
    }

    override fun updatePortfolio(
        p0: Contract?,
        p1: Double,
        p2: Double,
        p3: Double,
        p4: Double,
        p5: Double,
        p6: Double,
        p7: String?
    ) {
        log.trace("Not yet implemented: updatePortfolio")
    }

    override fun securityDefinitionOptionalParameterEnd(p0: Int) {
        log.debug("Not yet implemented: securityDefinitionOptionalParameterEnd")
    }

    override fun connectionClosed() {
        log.trace("Not yet implemented: connectionClosed")
    }

    override fun pnl(p0: Int, p1: Double, p2: Double, p3: Double) {
        log.trace("Not yet implemented: pnl")
    }

    override fun historicalTicksLast(p0: Int, p1: MutableList<HistoricalTickLast>?, p2: Boolean) {
        log.trace("Not yet implemented: historicalTicksLast")
    }

    override fun completedOrdersEnd() {
        log.debug("Not yet implemented: completedOrdersEnd")
    }

    override fun accountUpdateMultiEnd(p0: Int) {
        log.debug("Not yet implemented: accountUpdateMultiEnd")
    }

    override fun familyCodes(p0: Array<out FamilyCode>?) {
        log.trace("Not yet implemented: familyCodes")
    }

    override fun rerouteMktDataReq(p0: Int, p1: Int, p2: String?) {
        log.trace("Not yet implemented: rerouteMktDataReq")
    }

    override fun error(ex: Exception?) {
        log.error("{}", ex?.message, ex)
    }

    override fun error(ex: String?) {
        log.error("{}", ex)
    }

    override fun error(id: Int, errorCode: Int, errorMsg: String?) {
        if (id > 0 && !skipErrorCodes.keys.contains(errorCode)) {
            log.warn("Error id=$id code=$errorCode msg=$errorMsg")
            ibClient.requestEnd(id)
        } else {
            log.trace("code=$errorCode msg=$errorMsg")
        }
    }

    override fun newsArticle(p0: Int, p1: Int, p2: String?) {
        log.trace("Not yet implemented: newsArticle")
    }

    override fun positionMultiEnd(p0: Int) {
        log.debug("Not yet implemented: positionMultiEnd")
    }

    override fun pnlSingle(p0: Int, p1: Int, p2: Double, p3: Double, p4: Double, p5: Double) {
        log.trace("Not yet implemented: pnlSingle")
    }

    override fun securityDefinitionOptionalParameter(
        p0: Int,
        p1: String?,
        p2: Int,
        p3: String?,
        p4: String?,
        p5: MutableSet<String>?,
        p6: MutableSet<Double>?
    ) {
        log.trace("Not yet implemented: securityDefinitionOptionalParameter")
    }

    override fun softDollarTiers(p0: Int, p1: Array<out SoftDollarTier>?) {
        log.trace("Not yet implemented: softDollarTiers")
    }

    override fun headTimestamp(p0: Int, p1: String?) {
        log.trace("Not yet implemented: headTimestamp")
    }

    override fun bondContractDetails(p0: Int, p1: ContractDetails?) {
        log.trace("Not yet implemented: bondContractDetails")
    }

    override fun updateMktDepth(p0: Int, p1: Int, p2: Int, p3: Int, p4: Double, p5: Int) {
        log.trace("Not yet implemented: updateMktDepth")
    }

    override fun accountUpdateMulti(p0: Int, p1: String?, p2: String?, p3: String?, p4: String?, p5: String?) {
        log.trace("Not yet implemented: accountUpdateMulti")
    }

    override fun currentTime(p0: Long) {
        log.trace("Not yet implemented: currentTime")
    }

    override fun verifyAndAuthCompleted(p0: Boolean, p1: String?) {
        log.trace("Not yet implemented: verifyAndAuthCompleted")
    }

    override fun historicalNewsEnd(p0: Int, p1: Boolean) {
        log.debug("Not yet implemented: historicalNewsEnd")
    }

    override fun scannerData(
        p0: Int,
        p1: Int,
        p2: ContractDetails?,
        p3: String?,
        p4: String?,
        p5: String?,
        p6: String?
    ) {
        log.trace("Not yet implemented: scannerData")
    }

    override fun execDetailsEnd(p0: Int) {
        log.debug("Not yet implemented: execDetailsEnd")
    }

    override fun fundamentalData(p0: Int, p1: String?) {
        log.trace("Not yet implemented: fundamentalData")
    }

    override fun historicalTicks(p0: Int, p1: MutableList<HistoricalTick>?, p2: Boolean) {
        log.trace("Not yet implemented: historicalTicks")
    }

    override fun tickEFP(
        p0: Int,
        p1: Int,
        p2: Double,
        p3: String?,
        p4: Double,
        p5: Int,
        p6: String?,
        p7: Double,
        p8: Double
    ) {
        log.trace("Not yet implemented: tickEFP")
    }

    override fun accountDownloadEnd(p0: String?) {
        log.debug("Not yet implemented: accountDownloadEnd")
    }

    override fun tickGeneric(p0: Int, p1: Int, p2: Double) {
        log.trace("Not yet implemented: tickGeneric")
    }

    override fun verifyCompleted(p0: Boolean, p1: String?) {
        log.trace("Not yet implemented: verifyCompleted")
    }

    override fun updateAccountValue(p0: String?, p1: String?, p2: String?, p3: String?) {
        log.trace("Not yet implemented: updateAccountValue")
    }

    override fun smartComponents(p0: Int, p1: MutableMap<Int, MutableMap.MutableEntry<String, Char>>?) {
        log.trace("Not yet implemented: smartComponents")
    }

    override fun deltaNeutralValidation(p0: Int, p1: DeltaNeutralContract?) {
        log.trace("Not yet implemented: deltaNeutralValidation")
    }

    override fun managedAccounts(accountsList: String?) {
        log.trace("accountsList: {}", accountsList)
    }

    override fun marketDataType(reqId: Int, marketDataType: Int) {
        log.debug("MarketDataType. [$reqId], Type: [$marketDataType]")
    }

    override fun displayGroupUpdated(p0: Int, p1: String?) {
        log.trace("Not yet implemented: displayGroupUpdated")
    }

    override fun historicalDataEnd(p0: Int, p1: String?, p2: String?) {
        log.debug("Not yet implemented: historicalDataEnd")
    }

    override fun historicalDataUpdate(p0: Int, p1: Bar?) {
        log.trace("Not yet implemented: historicalDataUpdate")
    }

    override fun marketRule(p0: Int, p1: Array<out PriceIncrement>?) {
        log.trace("Not yet implemented: marketRule")
    }

    override fun displayGroupList(p0: Int, p1: String?) {
        log.trace("Not yet implemented: displayGroupList")
    }

    override fun execDetails(p0: Int, p1: Contract?, p2: Execution?) {
        log.trace("Not yet implemented: execDetails")
    }

    override fun realtimeBar(
        p0: Int,
        p1: Long,
        p2: Double,
        p3: Double,
        p4: Double,
        p5: Double,
        p6: Long,
        p7: Double,
        p8: Int
    ) {
        log.trace("Not yet implemented: realtimeBar")
    }

    override fun commissionReport(p0: CommissionReport?) {
        log.trace("Not yet implemented: commissionReport")
    }

    override fun tickSnapshotEnd(p0: Int) {
        log.debug("Not yet implemented: tickSnapshotEnd")
    }

    override fun accountSummary(reqId: Int, account: String, tag: String, value: String, currency: String) {
        log.trace("accountSummary: ReqId: $reqId, Acct: $account, Tag: $tag, Value: $value, Currency: $currency")
        var summary = (ibClient.requestGetValue(reqId) ?: ArrayList<AccountSummary>()) as MutableList<AccountSummary>
        summary.add(AccountSummary(account, tag, value, currency))
        ibClient.requestSetValue(reqId, summary)
    }

    override fun accountSummaryEnd(reqId: Int) {
        log.trace("accountSummaryEnd: ReqId: $reqId")
        ibClient.requestEnd(reqId)
    }

    override fun contractDetails(reqId: Int, contractDetails: ContractDetails?) {
        log.trace(EWrapperMsgGenerator.contractDetails(reqId, contractDetails))
        ibClient.requestSetValue(reqId, contractDetails)
    }

    override fun contractDetailsEnd(reqId: Int) {
        log.trace("ContractDetailsEnd. $reqId\n")
        ibClient.requestEnd(reqId)
    }

    override fun symbolSamples(reqId: Int, contractDescriptions: Array<out ContractDescription>) {
        log.trace("Contract Descriptions. Request: $reqId")
        val result: MutableList<Ticker> = ArrayList()
        for (description in contractDescriptions) {
            val contract = description.contract()
            val derivatives: MutableList<String> = ArrayList()
            for (derivative in description.derivativeSecTypes()) {
                derivatives.add(derivative)
            }
            result.add(
                Ticker(
                    contract.conid(),
                    contract.symbol(),
                    contract.secType(),
                    contract.primaryExch(),
                    contract.currency(),
                    derivatives
                )
            )

            log.trace(
                "Contract. ConId: ${contract.conid()}, Symbol: ${contract.symbol()}, SecType: ${contract.secType()},"
                        + "PrimaryExch: ${contract.primaryExch()}, Currency: ${contract.currency()}, DerivativeSecTypes: $derivatives"
            )
        }
        ibClient.requestSetValue(reqId, result)
        ibClient.requestEnd(reqId)
    }

    override fun tickByTickBidAsk(
        reqId: Int,
        time: Long,
        bidPrice: Double,
        askPrice: Double,
        bidSize: Int,
        askSize: Int,
        tickAttribBidAsk: TickAttribBidAsk?
    ) {
        log.debug(
            EWrapperMsgGenerator.tickByTickBidAsk(
                reqId,
                time,
                bidPrice,
                askPrice,
                bidSize,
                askSize,
                tickAttribBidAsk
            )
        )
        val result = TickData(
            time = time,
            bidPrice = bidPrice,
            askPrice = askPrice,
            bidSize = bidSize,
            askSize = askSize,
            tickAttribBidAsk = tickAttribBidAsk
        )
        ibClient.requestSetValue(reqId, result)
        ibClient.requestEnd(reqId)
    }

    override fun tickByTickAllLast(
        reqId: Int,
        tickType: Int,
        time: Long,
        price: Double,
        size: Int,
        tickAttribLast: TickAttribLast?,
        exchange: String?,
        specialConditions: String?
    ) {
        log.info(
            EWrapperMsgGenerator.tickByTickAllLast(
                reqId,
                tickType,
                time,
                price,
                size,
                tickAttribLast,
                exchange,
                specialConditions
            )
        )
        val result = TickData(
            tickType = tickType,
            time = time,
            price = price,
            size = size,
            tickAttribLast = tickAttribLast,
            exchange = exchange,
            specialConditions = specialConditions
        )
        ibClient.requestSetValue(reqId, result)
        ibClient.requestEnd(reqId)
    }

    override fun tickByTickMidPoint(reqId: Int, time: Long, midPoint: Double) {
        log.trace(EWrapperMsgGenerator.tickByTickMidPoint(reqId, time, midPoint))
        val result = TickData(time = time, midPoint = midPoint)
        ibClient.requestSetValue(reqId, result)
        ibClient.requestEnd(reqId)
    }

    override fun nextValidId(orderId: Int) {
        ibClient.setNextOrderId(orderId + 1)
        log.debug("next orderId: {}", ibClient.nextOrderId())
    }

    override fun orderStatus(
        orderId: Int, status: String?, filled: Double, remaining: Double, avgFillPrice: Double,
        permId: Int, parentId: Int, lastFillPrice: Double, clientId: Int, whyHeld: String?, mktCapPrice: Double
    ) {
        log.debug(
            "Order [orderId: $orderId, status: $status, filled: $filled, remaining: $remaining," +
                    " avgFillPrice: $avgFillPrice, permId: $permId, parentId: $parentId, lastFillPrice: $lastFillPrice, clientId: $clientId, " +
                    "whyHeld: $whyHeld, mktCapPrice: $mktCapPrice]"
        )

        if ("Cancelled" == status?.toLowerCase()) {
            ibClient.requestEnd(orderId)
        }
    }

    override fun openOrder(orderId: Int, contract: Contract?, order: Order?, orderState: OrderState?) {
        log.trace(EWrapperMsgGenerator.openOrder(orderId, contract, order, orderState))
        ibClient.ordersSetValue(orderId, OpenOrder(orderId, contract, order, orderState))
    }

    override fun openOrderEnd() {
        log.trace("OpenOrderEnd")
        ibClient.requestEnd(ibClient.nextOrderId())
    }

    override fun orderBound(reqId: Long, apiClientId: Int, apiOrderId: Int) {
        log.debug(EWrapperMsgGenerator.orderBound(reqId, apiClientId, apiOrderId))
    }

    override fun position(account: String, contract: Contract, position: Double, avgCost: Double) {
        log.debug(
            "Position. " + account + " - Symbol: " + contract.symbol() + ", SecType: " + contract.secType() + "," +
                    " Currency: " + contract.currency() + ", Position: " + position + ", Avg cost: " + avgCost
        )
        val list = (ibClient.requestGetValue(0) ?: ArrayList<Position>()) as MutableList<Position>
        list.add(Position(account, contract, position, avgCost))
        ibClient.requestSetValue(0, list)
    }

    override fun positionEnd() {
        ibClient.requestEnd(0)
    }

    override fun tickPrice(tickerId: Int, field: Int, price: Double, attribs: TickAttrib?) {
        log.debug("tickPrice: id={}, field={}, price={}", tickerId, field, price, attribs)
        if (field == 68 || field == 75) {
            val value = (ibClient.requestGetValue(tickerId) ?: Pair(0.0, 0.0)) as Pair<Double, Double>
            val pair = Pair(price, value.second)
            ibClient.requestSetValue(tickerId, pair)
            if (pair.first > 0 && pair.second > 0) {
                ibClient.requestEnd(tickerId)
            }
        }
    }

    override fun tickSize(tickerId: Int, field: Int, size: Int) {
        log.debug("tickSize: id={} field={} size={}", tickerId, field, size)
        if (field == 71 || field == 74) {
            val value = (ibClient.requestGetValue(tickerId) ?: Pair(0.0, 0.0)) as Pair<Double, Double>
            val pair = Pair(value.first, size)
            ibClient.requestSetValue(tickerId, pair)
            if (pair.first > 0 && pair.second > 0) {
                ibClient.requestEnd(tickerId)
            }
        }
    }

    override fun tickString(tickerId: Int, tickType: Int, value: String) {
        log.trace("Tick string. Ticker Id:$tickerId, Type: $tickType, Value: $value")
    }

    override fun tickReqParams(tickerId: Int, minTick: Double, bboExchange: String?, snapshotPermissions: Int) {
        log.trace("Tick req params. Ticker Id:$tickerId, Min tick: $minTick, bbo exchange: $bboExchange, Snapshot permissions: $snapshotPermissions")
    }
}