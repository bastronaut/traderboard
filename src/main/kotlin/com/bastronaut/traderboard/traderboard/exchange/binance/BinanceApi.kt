package com.bastronaut.traderboard.traderboard.exchange.binance

import com.bastronaut.traderboard.traderboard.exchange.ExchangeClient
import com.binance.api.client.BinanceApiAsyncRestClient
import com.binance.api.client.BinanceApiCallback
import com.binance.api.client.BinanceApiClientFactory
import com.binance.api.client.BinanceApiRestClient
import com.binance.api.client.domain.general.ServerTime


class BinanceApi (private val apiKey: String, private val apiSecret: String) : ExchangeClient {

    private val client: BinanceApiRestClient
    private val asyncClient: BinanceApiAsyncRestClient

    init {
        val factory = BinanceApiClientFactory.newInstance(apiKey, apiSecret)
        val client = factory.newRestClient()
        val asyncClient = factory.newAsyncRestClient()
        this.client = client
        this.asyncClient = asyncClient
    }


    override fun getServerTime() {
        val serverTime = this.client.getServerTime()
        print(serverTime)

        // not working yet... dunno not executing or not coming back? seems that in implementation if status is
        // 504 (timeout) there will be exception, simply nothing
        this.asyncClient.getServerTime { p0 ->
            print("on response...")
            print(p0.toString())
        }


        println("doin the async")
        this.asyncClient.getServerTime(object: BinanceApiCallback<ServerTime> {
            override fun onResponse(p0: ServerTime?) {
                print("on response!")
            }

            override fun onFailure(cause: Throwable?) {
                print("on failure")
            }
        })
    }

    override fun ping() {
        this.client.ping()
        this.asyncClient.ping({ print("ping done!") })
    }



}
