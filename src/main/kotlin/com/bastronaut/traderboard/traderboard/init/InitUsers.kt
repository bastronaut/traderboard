package com.bastronaut.traderboard.traderboard.init

import com.bastronaut.traderboard.traderboard.models.User
import com.bastronaut.traderboard.traderboard.repositories.UserRepository

/**
 * File level (no class spec), automatically generates class and makes methods static.
 * Dunno if better than making it part of companion object
 */

fun initUsers(userRepository: UserRepository) {
    deleteAllUsers(userRepository)
    insertTestUsers(userRepository)
}

fun deleteAllUsers(userRepository: UserRepository) {
    userRepository.deleteAll()
}

fun insertTestUsers(userRepository: UserRepository) {
    val a = User("bas@email.com", 1, "test")
    val b = User( "bob@email.com", 1, "test")
    val c = User("job@email.com", 1, "test")
    val d = User("ann@email.com", 1, "test")
    val users = ArrayList<User>()
    users.add(a)
    users.add(b)
    users.add(c)
    users.add(d)
    userRepository.saveAll(users)
}
