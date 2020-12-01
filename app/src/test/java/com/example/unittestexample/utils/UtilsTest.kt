package com.example.unittestexample.utils

import org.junit.Ignore
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*

internal class UtilsTest {

    val util: Utils = Utils()

    companion object {
        @BeforeAll
        @JvmStatic
        fun startBroadcast() = println("이 테스트에서 가장 먼저 실행되도록 하겠습니다.")

        @AfterAll
        @JvmStatic
        fun endBroadcast() = println("이 테스트에서 가장 마지막 실행되도록 하겠습니다.")
    }

    //BeforeEach 테스트 시작 전 실행되는 함수입니다.
    @BeforeEach
    fun setUp() = println("테스트 시작")

    //AfterEach 테스트 후 실행되는 함수입니다.
    @AfterEach
    fun tearDown() = println("테스트 종료")

    //Disabled 테스트를 위한 함수입니다.
    @Disabled("Not use - anyTest")
    @Test
    fun anyTest(){
        println("anyTest")
    }

    //문자열을 2개씩 자르는 테스트 입니다.
    @Test
    fun cutTwoWord() {
        //TC1
        val keyword: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        isEven(keyword.length)
        printCutList(util.cutTwoWord(keyword))

        //TC2
        val keyword1: String = """HELLO WORLD
            |FIND WORD
        """.trimMargin()
        isEven(keyword1.length)
        printCutList(util.cutTwoWord(keyword1))

        //TC3
        val keyword2: String = "CRY FIND"
        isEven(keyword2.length)
        printCutList(util.cutTwoWord(keyword2))

        //TC4
        val keyword3: String = ""
        isEven(keyword3.length)
        printCutList(util.cutTwoWord(keyword3))
    }

    private fun isEven(strLength: Int) = if (strLength % 2 == 0) {
        println("짝수입니다.")
    } else {
        println("홀수입니다.")
    }

    private fun printCutList(cutList: Array<String>) {
        for (str in cutList) {
            print("$str ")
        }
        println("\n")
    }
}