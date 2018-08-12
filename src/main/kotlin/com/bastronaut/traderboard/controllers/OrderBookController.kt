package com.bastronaut.traderboard.controllers


import com.bastronaut.traderboard.exchange.Exchange
import com.bastronaut.traderboard.exchange.ExchangeClient
import com.bastronaut.traderboard.exchange.ExchangeClientFactory
import com.bastronaut.traderboard.exchange.OrderBook
import com.bastronaut.traderboard.models.inout.OrderBookInfo
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/api/orderbook")
public class OrderBookController(val exchangeFactory: ExchangeClientFactory) {

    var client: ExchangeClient = exchangeFactory.createExchangeClient(Exchange.BINANCE, "test", "yo")

    @GetMapping(value = "")
    fun getOrderbook(): OrderBookInfo {
        val orderbook = client.getOrderBook("NEOETH")
        return OrderBookInfo("test", "NEOETH", orderbook)
    }
}
