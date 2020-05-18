package com.github.shk0da.ib.client

import com.github.shk0da.ib.model.*
import com.ib.client.*
import org.slf4j.LoggerFactory


internal class IBWrapper(private val ibClient: IBClient) : EWrapper {

    private val log = LoggerFactory.getLogger(IBWrapper::class.java)

    override fun historicalData(p0: Int, p1: Bar?) {
        TODO("Not yet implemented")
    }

    override fun rerouteMktDepthReq(p0: Int, p1: Int, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun mktDepthExchanges(p0: Array<out DepthMktDataDescription>?) {
        TODO("Not yet implemented")
    }

    override fun histogramData(p0: Int, p1: MutableList<HistogramEntry>?) {
        TODO("Not yet implemented")
    }

    override fun tickNews(p0: Int, p1: Long, p2: String?, p3: String?, p4: String?, p5: String?) {
        TODO("Not yet implemented")
    }

    override fun updateAccountTime(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun verifyAndAuthMessageAPI(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun newsProviders(p0: Array<out NewsProvider>?) {
        TODO("Not yet implemented")
    }

    override fun updateNewsBulletin(p0: Int, p1: Int, p2: String?, p3: String?) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun scannerParameters(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun scannerDataEnd(p0: Int) {
        log.debug("scannerDataEnd")
    }

    override fun verifyMessageAPI(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun positionMulti(p0: Int, p1: String?, p2: String?, p3: Contract?, p4: Double, p5: Double) {
        TODO("Not yet implemented")
    }

    override fun completedOrder(p0: Contract?, p1: Order?, p2: OrderState?) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun receiveFA(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun historicalTicksBidAsk(p0: Int, p1: MutableList<HistoricalTickBidAsk>?, p2: Boolean) {
        TODO("Not yet implemented")
    }

    override fun historicalNews(p0: Int, p1: String?, p2: String?, p3: String?, p4: String?) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun securityDefinitionOptionalParameterEnd(p0: Int) {
        log.debug("securityDefinitionOptionalParameterEnd")
    }

    override fun connectionClosed() {
        TODO("Not yet implemented")
    }

    override fun pnl(p0: Int, p1: Double, p2: Double, p3: Double) {
        TODO("Not yet implemented")
    }

    override fun historicalTicksLast(p0: Int, p1: MutableList<HistoricalTickLast>?, p2: Boolean) {
        TODO("Not yet implemented")
    }

    override fun completedOrdersEnd() {
        log.debug("completedOrdersEnd")
    }

    override fun accountUpdateMultiEnd(p0: Int) {
        log.debug("accountUpdateMultiEnd")
    }

    override fun familyCodes(p0: Array<out FamilyCode>?) {
        TODO("Not yet implemented")
    }

    override fun rerouteMktDataReq(p0: Int, p1: Int, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun error(ex: Exception?) {
        log.error("{}", ex?.message, ex)
    }

    override fun error(ex: String?) {
        log.error("{}", ex)
    }

    override fun error(id: Int, errorCode: Int, errorMsg: String?) {
        if (id > 0) {
            log.warn("Error id=$id code=$errorCode msg=$errorMsg")
            ibClient.requestEnd(id)
        } else {
            log.trace("code=$errorCode msg=$errorMsg")
        }
    }

    override fun newsArticle(p0: Int, p1: Int, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun positionMultiEnd(p0: Int) {
        log.debug("positionMultiEnd")
    }

    override fun pnlSingle(p0: Int, p1: Int, p2: Double, p3: Double, p4: Double, p5: Double) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun softDollarTiers(p0: Int, p1: Array<out SoftDollarTier>?) {
        TODO("Not yet implemented")
    }

    override fun headTimestamp(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun bondContractDetails(p0: Int, p1: ContractDetails?) {
        TODO("Not yet implemented")
    }

    override fun updateMktDepth(p0: Int, p1: Int, p2: Int, p3: Int, p4: Double, p5: Int) {
        TODO("Not yet implemented")
    }

    override fun accountUpdateMulti(p0: Int, p1: String?, p2: String?, p3: String?, p4: String?, p5: String?) {
        TODO("Not yet implemented")
    }

    override fun currentTime(p0: Long) {
        TODO("Not yet implemented")
    }

    override fun verifyAndAuthCompleted(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun historicalNewsEnd(p0: Int, p1: Boolean) {
        log.debug("historicalNewsEnd")
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
        TODO("Not yet implemented")
    }

    override fun execDetailsEnd(p0: Int) {
        log.debug("execDetailsEnd")
    }

    override fun fundamentalData(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun tickSize(p0: Int, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun historicalTicks(p0: Int, p1: MutableList<HistoricalTick>?, p2: Boolean) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun accountDownloadEnd(p0: String?) {
        log.debug("accountDownloadEnd")
    }

    override fun tickGeneric(p0: Int, p1: Int, p2: Double) {
        TODO("Not yet implemented")
    }

    override fun verifyCompleted(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun tickString(p0: Int, p1: Int, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun updateAccountValue(p0: String?, p1: String?, p2: String?, p3: String?) {
        TODO("Not yet implemented")
    }

    override fun smartComponents(p0: Int, p1: MutableMap<Int, MutableMap.MutableEntry<String, Char>>?) {
        TODO("Not yet implemented")
    }

    override fun deltaNeutralValidation(p0: Int, p1: DeltaNeutralContract?) {
        TODO("Not yet implemented")
    }

    override fun managedAccounts(accountsList: String?) {
        log.trace("accountsList: {}", accountsList)
    }

    override fun marketDataType(p0: Int, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun displayGroupUpdated(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun historicalDataEnd(p0: Int, p1: String?, p2: String?) {
        log.debug("historicalDataEnd")
    }

    override fun historicalDataUpdate(p0: Int, p1: Bar?) {
        TODO("Not yet implemented")
    }

    override fun marketRule(p0: Int, p1: Array<out PriceIncrement>?) {
        TODO("Not yet implemented")
    }

    override fun tickReqParams(p0: Int, p1: Double, p2: String?, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun displayGroupList(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun execDetails(p0: Int, p1: Contract?, p2: Execution?) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun tickPrice(p0: Int, p1: Int, p2: Double, p3: TickAttrib?) {
        TODO("Not yet implemented")
    }

    override fun commissionReport(p0: CommissionReport?) {
        TODO("Not yet implemented")
    }

    override fun tickSnapshotEnd(p0: Int) {
        log.debug("tickSnapshotEnd")
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
        val nextOrderId = ibClient.nextOrderId()
        val id = if (orderId != nextOrderId) nextOrderId else orderId
        val list = (ibClient.requestGetValue(id) ?: ArrayList<OpenOrder>()) as MutableList<OpenOrder>
        list.add(OpenOrder(orderId, contract, order, orderState))
        ibClient.requestSetValue(id, list)
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
        log.debug("positionEnd")
        ibClient.requestEnd(0)
    }
}