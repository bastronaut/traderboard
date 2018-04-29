package com.bastronaut.traderboard.traderboard.exchange.binance

import com.bastronaut.traderboard.traderboard.exchange.ExchangeClient
import com.binance.api.client.BinanceApiAsyncRestClient
import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory
import com.binance.api.client.BinanceApiRestClient
import com.binance.api.client.domain.general.ServerTime
import com.binance.api.client.domain.market.OrderBook


class BinanceApi (private val apiKey: String, private val apiSecret: String) : ExchangeClient {

    private val client: BinanceApiRestClient

    init {
        val factory = BinanceApiClientFactory.newInstance(apiKey, apiSecret)
        val client = factory.newRestClient()
        this.client = client
    }


    override fun getServerTime() {
        val serverTime = this.client.getServerTime()
        print(serverTime)
    }

    override fun ping() {
        this.client.ping()
    }

    override fun getOrderBook(symbol: String, qty: Int) {
    // TODO: decide what to do... if we want to return an OrderBook, we have to
        // change the interface return type. this ties the interface to the
        // binance api class and kind of defeats the purpose of the interface...

//        return this.client.getOrderBook(symbol, qty)
    }




}
