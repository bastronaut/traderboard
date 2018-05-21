package com.bastronaut.traderboard.traderboard.exchange

class OrderBookWrapperImpl(override val bids: List<OrderBookEntryWrapper>, override val asks: List<OrderBookEntryWrapper>) : OrderBookWrapper