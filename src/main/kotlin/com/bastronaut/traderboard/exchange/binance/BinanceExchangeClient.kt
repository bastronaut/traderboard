package com.bastronaut.traderboard.exchange.binance

import com.bastronaut.traderboard.exchange.ExchangeClient
import com.bastronaut.traderboard.exchange.OrderBook
import com.bastronaut.traderboard.exchange.OrderBookEntryImpl
import com.bastronaut.traderboard.exchange.OrderBookImpl

import com.binance.api.client.BinanceApiClientFactory
import com.binance.api.client.BinanceApiRestClient


class BinanceExchangeClient (private val apiKey: String, private val apiSecret: String) : ExchangeClient {

    private val client: BinanceApiRestClient
    private val DEFAULTORDERBOOKLIMIT = 10

    init {
        val factory = BinanceApiClientFactory.newInstance(apiKey, apiSecret)
        val client = factory.newRestClient()
        this.client = client
    }


    override fun getServerTime() {
        val serverTime = this.client.serverTime
        print(serverTime)
    }

    override fun ping() {
        this.client.ping()
    }

    override fun getOrderBook(symbol: String): OrderBook {
        val orderBook = this.client.getOrderBook(symbol, DEFAULTORDERBOOKLIMIT)
        val asks = orderBook.asks
        val bids = orderBook.bids

        val wrappedAsks = asks.map{
            OrderBookEntryImpl(it.price, it.qty)
        }
        val wrappedBids = bids.map {
            OrderBookEntryImpl(it.price, it.qty)
        }
//        val ask = OrderBookEntryImpl("5", "1")
//        val bid = OrderBookEntryImpl("5", "1")

        return OrderBookImpl(wrappedAsks, wrappedBids)
//            return OrderBookImpl(listOf(ask), listOf(bid))
    }






}
