package com.bastronaut.traderboard.exchange

/**
 *
 */
interface ExchangeClient {

    /**
     *  Generic Server calls
     *  */
    fun getServerTime()
    fun ping()

    /**
     * Market data endpoints
     */
    fun getOrderBook(symbol: String): OrderBookWrapper

    /**
     *  User account calls
     *  */
//    fun getAllAssets()
}