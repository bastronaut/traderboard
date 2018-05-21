package com.bastronaut.traderboard.traderboard.exchange

/**
 * Wrapper class for different exchanges' Order Book class
 */
interface OrderBookWrapper {
    val bids: List<OrderBookEntryWrapper>
    val asks: List<OrderBookEntryWrapper>
}