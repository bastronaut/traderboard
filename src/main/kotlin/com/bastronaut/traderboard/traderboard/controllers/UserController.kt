package com.bastronaut.traderboard.traderboard.controllers

import com.bastronaut.traderboard.traderboard.entities.User
import com.bastronaut.traderboard.traderboard.init.initUsers
import com.bastronaut.traderboard.traderboard.repository.UserRepository
import com.bastronaut.traderboard.traderboard.services.UserService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.*

/**
 * Annotations:
 * @RequestMapping maps web requests to Spring Controller methods. All requests come in to /users in this case
 *
 * Query creation mechanism for JPA, can use keywords as described in table:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 *
 *
 */
@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    /*
    Start GET methods
     */

    /**
     * Gets all users
     * @GetMapping is a shortcut for @RequestMapping(method=RequestMethod.GET)
     */
    @GetMapping(value = "")
    fun getUsers() : List<User>  = userService.findAll()

    @GetMapping(value = "/{username}")
    fun getUserByUsername(@PathVariable username: String): User? {
        return userService.findByUserName(username) ?: return null
    }

    @GetMapping(value = "/reset")
    fun resetUsers() {
        userService.resetUsers()
    }


    /*
    Start POST methods
     */

    @PostMapping(value="/{username}")
    fun insertUser(@PathVariable username: String): User? {
        return userService.insertUser(username)
    }



}
