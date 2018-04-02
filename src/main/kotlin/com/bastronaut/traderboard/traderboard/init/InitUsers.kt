package com.bastronaut.traderboard.traderboard.init

import com.bastronaut.traderboard.traderboard.models.User
import com.bastronaut.traderboard.traderboard.repository.UserRepository

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
    val a = User("bas")
    val b = User("bob")
    val c = User("job")
    val d = User("ann")
    val users = ArrayList<User>()
    users.add(a)
    users.add(b)
    users.add(c)
    users.add(d)
    userRepository.saveAll(users)
}
