package com.bastronaut.traderboard.traderboard.repositories

import com.bastronaut.traderboard.traderboard.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UserRepository: JpaRepository<User, Long> {

    fun findByUsername(username: String) : User?


    /**
     * In the query, we have to use the Class name rather than the table name. DOH
     */
    @Query("select u from User u")
    fun findUserCustomQuery(custom: String): List<User>

    /**
     * Same as above but with named params
     */
    @Query("select u from User u where u.username = :username")
    fun findUserCustomNamedQuery(@Param("username") username: String) : User?

    /*
     * Using native SQL
     */
    @Query("SELECT * from User", nativeQuery = true)
    fun findUserCustomNativeQuery() : List<User>
}
