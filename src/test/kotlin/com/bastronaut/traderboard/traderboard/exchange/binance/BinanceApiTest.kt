package com.bastronaut.traderboard.traderboard.exchange.binance

import org.junit.Before
import org.junit.Test


internal class BinanceApiTest {

    private lateinit var binanceApi: BinanceApi

    @Before
    fun initialize() {
        this.binanceApi = BinanceApi("hi", "there")
    }

    @Test
    fun getServerTime() {
        binanceApi.getServerTime()
    }

}