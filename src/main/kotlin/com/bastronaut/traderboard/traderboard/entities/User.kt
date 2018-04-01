package com.bastronaut.traderboard.traderboard.entities

import javax.persistence.*

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
 * @param name
 * @param can be ignored randomly generated
 */
@Entity
@Table(name = "Users", uniqueConstraints = [UniqueConstraint(columnNames = ["username"])])
class User(val username: String,
           @Id @GeneratedValue(strategy = GenerationType.AUTO)
           val id: Long = 0) {

}


