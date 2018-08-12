package com.bastronaut.traderboard

import com.bastronaut.traderboard.init.initUsers
import com.bastronaut.traderboard.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class TraderboardApplication {

    @Bean
    open fun init(userRepository: UserRepository) = CommandLineRunner {
        initUsers(userRepository)
    }
}

fun main(args: Array<String>) {
    runApplication<TraderboardApplication>(*args)
}

