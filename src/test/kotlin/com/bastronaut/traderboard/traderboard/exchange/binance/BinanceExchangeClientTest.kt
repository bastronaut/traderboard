package com.bastronaut.traderboard.traderboard.exchange.binance

import com.bastronaut.traderboard.exchange.binance.BinanceExchangeClient
import org.junit.Before
import org.junit.Test


internal class BinanceExchangeClientTest {

    private lateinit var binanceExchangeClient: BinanceExchangeClient

    @Before
    fun initialize() {
        this.binanceExchangeClient = BinanceExchangeClient("hi", "there")
    }

    @Test
    fun getServerTime() {
        binanceExchangeClient.getServerTime()
    }

    @Test
    fun ping() {
        binanceExchangeClient.ping()
    }

    @Test
    fun testGetOrderBook() {
        val orderBook = binanceExchangeClient.getOrderBook("NEOETH")
        val asks = orderBook.asks
        val bids = orderBook.bids

        asks.forEach { print("Price: ${it.price}, Qty: ${it.qty}")}
    }

}