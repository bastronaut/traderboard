package com.bastronaut.traderboard.traderboard.controllers

import com.bastronaut.traderboard.traderboard.models.User
import com.bastronaut.traderboard.traderboard.repositories.UserRepository
import com.bastronaut.traderboard.traderboard.services.UserService
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.dao.NonTransientDataAccessException
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


//@RunWith(SpringRunner::class)
//@WebMvcTest(UserController::class)
@RunWith(MockitoJUnitRunner::class)
class UserControllerTest {
//    @Autowired
//    lateinit var mockMvc: MockMvc
//
//    @MockBean
//    lateinit var userService: UserService
//
//
//    @Test
//    fun testGetUsers() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
//                .andExpect(status().isOk())
//    }

//    @Test
//    fun testGetUserByUsername() {
//        given(userService.findByUserName("bas")).willReturn(User("bas", "bas@email.com"))
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/users/bas"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("username").value("bas"))
//    }
//
//    @Test
//    fun testInsertUser() {
//        mockMvc.perform(MockMvcRequestBuilders.post("/users/testuser"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("username").value("testuser"))
//    }

    @Mock
    lateinit var mockUserService: UserService

    @InjectMocks
    lateinit var userrController: UserController

    @Test
    fun testSomethingMockito() {
        Mockito.`when`(mockUserService.findByUserName("testy"))
                .thenReturn(User("testy", "testy@email.com", 1))
        var testUser = userrController.getUserByUsername("testy")
        assertEquals("testy", testUser?.username)
        assertEquals("testy@email.com", testUser?.email)
        assertEquals(1L, testUser?.id)
    }


}