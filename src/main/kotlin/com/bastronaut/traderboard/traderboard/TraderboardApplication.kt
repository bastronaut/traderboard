package com.bastronaut.traderboard.traderboard

import com.bastronaut.traderboard.traderboard.init.initUsers
import com.bastronaut.traderboard.traderboard.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TraderboardApplication {

    @Bean
    fun init(userRepository: UserRepository) = CommandLineRunner {
        initUsers(userRepository)
    }
}

fun main(args: Array<String>) {
    runApplication<TraderboardApplication>(*args)
}
