package com.bastronaut.traderboard.traderboard.exchange

/**
 * Wrapper class for different exchanges' Order Book Entry class
 */
interface OrderBookEntryWrapper {
    val price: String
    val qty: String
}