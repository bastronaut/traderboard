package com.bastronaut.traderboard.exchange

class OrderBookImpl(override val bids: List<OrderBookEntry>, override val asks: List<OrderBookEntry>) : OrderBook