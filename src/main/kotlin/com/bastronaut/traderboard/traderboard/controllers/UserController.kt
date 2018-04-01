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
 * @RequestMapping maps web requests to Spring Controller methods
 */
@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    /**
     * listens to /users/all
     * @GetMapping is a shortcut for @RequestMapping(method=RequestMethod.GET)
     */
    @GetMapping(value = "")
    fun getUsers() : List<User>  = userService.findAll()


    @GetMapping(value = "/{username}")
    fun getUserByUsername(@PathVariable username: String): List<User > {
//        userRepository.findByUserUsername(username)
    }


    @PostMapping(value="/{username}")
    fun insertUser(@PathVariable username: String): List<User> {
        return userService.insertUser(username)
    }

    fun testUser(@RequestBody user: User) {
        val x = user.username
        print(x)
    }

    @GetMapping(value = "/reset")
    fun resetUsers() {
        userService.resetUsers()
    }
}
