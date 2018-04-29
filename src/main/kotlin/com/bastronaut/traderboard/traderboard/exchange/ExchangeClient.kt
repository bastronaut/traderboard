package com.bastronaut.traderboard.traderboard.exchange

interface ExchangeClient {

    /**
     *  Generic Server calls
     *  */
    fun getServerTime()
    fun ping()

    /**
     * Market data endpoints
     */
    fun getOrderBook(symbol: String, qty: Int)

    /**
     *  User account calls
     *  */
//    fun getAllAssets()
}