package com.bastronaut.traderboard.exchange

/**
 * Wrapper class for different exchanges' Order Book class
 */
interface OrderBook {
    val bids: List<OrderBookEntry>
    val asks: List<OrderBookEntry>
}