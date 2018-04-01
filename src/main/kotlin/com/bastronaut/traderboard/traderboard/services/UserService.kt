package com.bastronaut.traderboard.traderboard.services

import com.bastronaut.traderboard.traderboard.entities.User
import com.bastronaut.traderboard.traderboard.init.initUsers
import com.bastronaut.traderboard.traderboard.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository) {

    fun findAll() = userRepository.findAll()

    fun insertUser(username: String) : List<User> {
        val user = User(username)
        userRepository.save(user)
        return userRepository.findAll()
    }

    fun resetUsers() = initUsers(userRepository)

}