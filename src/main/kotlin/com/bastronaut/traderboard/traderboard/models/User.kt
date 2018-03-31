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
 *
 * Seems that, when no default values are added for arguments, it generates a hybris
 * exception? org.hibernate.InstantiationException: No default constructor for entity: ..User
 */
@Entity
class User(val name: String = "", val age: Int = 0,
           @Id @GeneratedValue(strategy = GenerationType.AUTO)
           val id: Long = 0)


