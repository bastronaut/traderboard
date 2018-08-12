package com.bastronaut.traderboard.models.inout

import com.bastronaut.traderboard.exchange.OrderBook
import com.bastronaut.traderboard.exchange.OrderBookEntry
import com.fasterxml.jackson.annotation.JsonRootName


@JsonRootName("orderBookInfo")
class OrderBookInfo(val timestamp: String, val request: String, val orderbook: OrderBook)