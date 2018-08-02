package com.bastronaut.traderboard.exchange.binance

import com.bastronaut.traderboard.exchange.ExchangeClient
import com.bastronaut.traderboard.exchange.OrderBookEntryWrapperImpl
import com.bastronaut.traderboard.exchange.OrderBookWrapper
import com.bastronaut.traderboard.exchange.OrderBookWrapperImpl
import com.binance.api.client.BinanceApiClientFactory
import com.binance.api.client.BinanceApiRestClient


class BinanceApi (private val apiKey: String, private val apiSecret: String) : ExchangeClient {

    private val client: BinanceApiRestClient
    private val DEFAULTORDERBOOKLIMIT = 10

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

    override fun getOrderBook(symbol: String): OrderBookWrapper {
        val orderBook = this.client.getOrderBook(symbol, DEFAULTORDERBOOKLIMIT)
        val asks = orderBook.asks
        val bids = orderBook.bids

        val wrappedAsks = asks.map{
            OrderBookEntryWrapperImpl(it.price, it.qty)
        }
        val wrappedBids = bids.map {
            OrderBookEntryWrapperImpl(it.price, it.qty)
        }
        return OrderBookWrapperImpl(wrappedAsks, wrappedBids)
    }






}
