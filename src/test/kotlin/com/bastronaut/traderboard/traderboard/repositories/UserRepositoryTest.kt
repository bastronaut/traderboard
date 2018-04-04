package com.bastronaut.traderboard.traderboard.repositories

import com.bastronaut.traderboard.traderboard.models.User
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * DataJpaTest will configure an in-memory embedded db.
 * Uses @Transactional under the hood to roll back at the end
 */
@RunWith(SpringRunner::class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository


    @Test
    fun testFindByUsername() {
        var testuser = userRepository.findByUsername("test")

        Assertions.assertThat(testuser?.username?.equals("test"))
        Assertions.assertThat(testuser?.email?.equals("test@email.com"))
    }

    @Test
    fun testCreateUser() {
        val initialCount = userRepository.count()
        var testUser = User("test", "test@email.com")
        var inserted = userRepository.save(testUser)
        Assertions.assertThat(inserted.username == "test")
        Assertions.assertThat(userRepository.count() == initialCount + 1)
    }
}