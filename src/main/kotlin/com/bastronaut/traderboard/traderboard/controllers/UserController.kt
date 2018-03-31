package com.bastronaut.traderboard.traderboard.controllers

import com.bastronaut.traderboard.traderboard.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

/**
 * Annotations:
 * @RequestMapping maps web requests to Spring Controller methods
 */
@RestController
@RequestMapping("/users")
class UserController(val userRepository: UserRepository) {

    /**
     * listens to /users/all
     * @GetMapping is a shortcut for @RequestMapping(method=RequestMethod.GET)
     */
    @GetMapping(value = "/all")
    fun getUsers() : List<User>  = userRepository.findAll()

    @PostMapping(value="/{name}/{age}")
    fun insertUsers(@PathVariable name: String, @PathVariable age: Int): List<User> {
        val user = User(name, age)
        userRepository.save(user)
        return userRepository.findAll()
    }
}

interface UserRepository: JpaRepository<User, Long>