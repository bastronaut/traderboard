package com.bastronaut.traderboard.exchange

/**
 * Wrapper class for different exchanges' Order Book Entry class
 */
interface OrderBookEntry {
    val price: String
    val qty: String
}