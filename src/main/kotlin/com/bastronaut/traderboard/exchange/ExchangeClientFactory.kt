package com.bastronaut.traderboard.exchange

import com.bastronaut.traderboard.exchange.binance.BinanceApi

public class ExchangeClientFactor {

    fun createExchangeClient(exchange: Exchange, apiKey: String, apiSecret: String): ExchangeClient? {
        when (exchange) {
            Exchange.BINANCE -> return BinanceApi(apiKey, apiSecret)
        }
    }
}


enum class Exchange {
    BINANCE
}