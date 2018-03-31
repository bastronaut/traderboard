package com.bastronaut.traderboard.traderboard.models

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Annotations info:
 * @Entity param specifics that class is an entity
 * @Id specify the field as a primary key
 * @GeneratedValue defines the creation strategy
 */
@Entity
class User(private val name: String, val age: Int,
           @Id @GeneratedValue(strategy = GenerationType.AUTO)
           val id: Long = 2) {

    fun getYo() = "yo"
}


