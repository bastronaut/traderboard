package com.bastronaut.traderboard.exchange

import com.bastronaut.traderboard.exchange.binance.BinanceExchangeClient
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Component
public class ExchangeClientFactory {

    fun createExchangeClient(exchange: Exchange, apiKey: String, apiSecret: String): ExchangeClient {
        when (exchange) {
            Exchange.BINANCE -> return BinanceExchangeClient(apiKey, apiSecret)
        }
    }
}


enum class Exchange {
    BINANCE
}