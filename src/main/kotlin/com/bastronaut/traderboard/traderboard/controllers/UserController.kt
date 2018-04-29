package com.bastronaut.traderboard.traderboard.controllers

import com.bastronaut.traderboard.traderboard.exceptions.InvalidException
import com.bastronaut.traderboard.traderboard.exceptions.InvalidRequest
import com.bastronaut.traderboard.traderboard.models.User
import com.bastronaut.traderboard.traderboard.models.inout.RegisterUser
import com.bastronaut.traderboard.traderboard.services.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.validation.Errors

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
@RequestMapping("/api/users")
class UserController(val userService: UserService) {

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


    /**
     * The @RequestBody annotation binds the method param to the body of the POST request
     */
    @PostMapping(value="")
    fun registerUser(@Valid registerUser: RegisterUser, errors: Errors): User? {
        InvalidRequest.check(errors)
        // add validator logic here
        return userService.insertUser(registerUser)
    }



}
