package com.example.unittestexample.utils


import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException
import java.time.Duration

/**
 * Junit을 활용한 Unit테스트
 * */
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
    fun anyTest() {
        println("anyTest")
    }

    //짝수 문자열을 2개씩 자르는 테스트 입니다.
    //assertArrayEqual은 배열끼리 동일한 값을 가졌는지 체크합니다.
    @Test
    fun cutTwoWordEven() {
        val keyword: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val checkList: Array<String> =
            arrayOf("AB", "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR", "ST", "UV", "WX", "YZ")
        assertArrayEquals(checkList, util.cutTwoWord(keyword))
    }

    //홀수 문자열을 2개씩 자르는 테스트 입니다.
    @Test
    fun cutTwoWordOdd() {
        val keyword2: String = "ABC"
        val checkList2: Array<String> = arrayOf("AB", "C")
        assertArrayEquals(checkList2, util.cutTwoWord(keyword2))
    }

    //값이 null인지 확인합니다.
    //assertTrue는 현재 조건이 참인지 검사합니다.
    @Test
    fun isNull() {
        val name: String? = null
        assertTrue(null == name)
    }

    //assertTimeout은 정해진 시간내로 처리되는지 확인합니다.
    @Test
    fun testFactorial() {
        assertTimeout(Duration.ofMillis(10)) {
            Thread.sleep(100)
        }
    }

    //assertEqual은 대입한 두개의 값이 일치해야 테스트를 성공 시킵니다.
    @Test
    fun testEqual() {
        val myName: String = "Choi"
        val herName: String = "Kim"
        val friendName: String = "Choi"

        //주석 처리된 코드는 error 발생
        //assertEquals(myName,herName,"서로 이름이 같지 않습니다.")
        assertEquals(myName, friendName, "서로 이름이 같지 않습니다.")
    }

    //assertAll 한가지가 아닌 다수의 테스트가 필요할때 사용합니다.
    @Test
    fun testEqualAll() {
        val myName: String = "Choi"
        val youName: String = "Choi"
        val myAge: Int = 28
        val myList: ArrayList<Int> = ArrayList()
        val youList: ArrayList<Int> = ArrayList()

        assertAll({ assertEquals(myName, youName) },
            { assertNotNull(myAge) },
            { assertEquals(myList, youList) })
    }

    /**
     * assertThrows(체크할 exception.class,발생할 exception)
     * 예외 클래스가 일치하면 test passed가 된다.
     * 하지만 예외 클래스만 일치하지 않고, 예외 메세지까지 일치되어야 하므로
     * 일치하는 것이 좋다.
     */
    @Test
    fun testThrows() {
        val exception = assertThrows(IllegalArgumentException().javaClass) {
            Study(-10)
        }

        assertEquals("The price cannot be below zero", exception.message)
    }
}
