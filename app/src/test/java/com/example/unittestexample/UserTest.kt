package com.example.unittestexample

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Mockito 를 활용한 테스트
 * */
@RunWith(MockitoJUnitRunner::class)
internal class UserTest{

    @Test
    fun userTest(){
        val user:User = mock(User::class.java)
        `when`(user.getId()).thenReturn(100)
        `when`(user.getUrl(100)).thenReturn("https://codechacha.com")

        assertEquals(100,user.getId())
        assertEquals(user.getUrl(user.getId()),"https://codechacha.com")

    }
}