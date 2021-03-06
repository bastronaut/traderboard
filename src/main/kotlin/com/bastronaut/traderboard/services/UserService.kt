package com.bastronaut.traderboard.services

import com.bastronaut.traderboard.models.User
import com.bastronaut.traderboard.exceptions.InvalidException
import com.bastronaut.traderboard.init.initUsers
import com.bastronaut.traderboard.models.inout.RegisterUser
import com.bastronaut.traderboard.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository) {



    fun findAll() = userRepository.findAll()

    fun insertUser(register: RegisterUser) : User? {
        val token = createToken(register.email!!)
        val user = User(username = register.email!!, id = 0,
                password = register.password, token = token)
        userRepository.save(user)
        return user
    }

    fun findByUserName(username: String) : User? {
        return userRepository.findByUsername(username) ?: throw InvalidException(null)
    }


    fun createToken(email: String): String {
        return "placeholder"
    }

    fun resetUsers() = initUsers(userRepository)


}



