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
 * @GeneratedValue defines the creation strategy - NOTE: seems that it doesnt matter what
 * we pass to the constructor as id argument, it will be stored with an auto generated ID
 *
 * Seems that, when no default values are added for arguments, it generates a hybris
 * exception? org.hibernate.InstantiationException: No default constructor for entity: ..User
 * Seems problematic when constructor parameters are more complex objects
 *
 * FIX: kotlin no-arg compiler plugin generates synthetic default constructor for
 * class with @Entity (and some others?) annotation. Added kotlin-noarg to buildscript
 * dependencies and apply plugins
 *
 */
@Entity
class User(val name: String, val age: Int,
           @Id @GeneratedValue(strategy = GenerationType.AUTO)
           val id: Long = 0) {



}


