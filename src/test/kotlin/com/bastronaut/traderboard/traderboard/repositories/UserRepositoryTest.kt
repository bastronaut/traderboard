package com.bastronaut.traderboard.traderboard.repositories

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun testFindByUsername() {
        var basuser = userRepository.findByUsername("bas")

        Assertions.assertThat(basuser?.username.equals("bas"))
        Assertions.assertThat(basuser?.email.equals("bas@email.com"))g
    }
}