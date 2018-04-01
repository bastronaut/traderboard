package com.bastronaut.traderboard.traderboard.repository

import com.bastronaut.traderboard.traderboard.entities.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User, Long> {

    fun findUByUserUsername(username: String) : User


}
