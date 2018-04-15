package com.bastronaut.traderboard.traderboard.exchange

import com.bastronaut.traderboard.traderboard.exchange.binance.BinanceApi

public class ExchangeClientFactory {

    fun createExchangeClient(exchange: Exchange, apiKey: String, apiSecret: String): ExchangeClient? {
        when (exchange) {
            Exchange.BINANCE -> return BinanceApi(apiKey, apiSecret)
        }
    }
}

enum class Exchange {
    BINANCE
}