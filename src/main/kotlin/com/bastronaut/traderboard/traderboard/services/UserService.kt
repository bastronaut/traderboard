package com.bastronaut.traderboard.traderboard.services

import com.bastronaut.traderboard.traderboard.models.User
import com.bastronaut.traderboard.traderboard.exceptions.UserNotFoundException
import com.bastronaut.traderboard.traderboard.init.initUsers
import com.bastronaut.traderboard.traderboard.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository) {

    fun findAll() = userRepository.findAll()

    fun insertUser(username: String) : User? {
        val user = User(username, "placeholder")
        userRepository.save(user)
        return user
    }

    fun resetUsers() = initUsers(userRepository)

    fun findByUserName(username: String) : User? {
        return userRepository.findByUsername(username) ?: throw UserNotFoundException()
    }


}



