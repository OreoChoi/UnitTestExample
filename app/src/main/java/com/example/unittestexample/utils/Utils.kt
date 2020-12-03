package com.example.unittestexample.utils

class Utils {

    //문자열을 2개씩 자릅니다.
    fun cutTwoWord(str: String): Array<String> {
        val arrSize: Int = if (str.length % 2 == 0) {
            str.length / 2
        } else {
            str.length / 2 + 1
        }
        val arr: Array<String> = Array(arrSize) { "" }
        var string: String = str

        for (i in arr.indices) {
            if (string.length > 1) {   //문자열 2자리 이상 시
                arr[i] = string.substring(0, 2)
                string = string.substring(2)
            } else {
                arr[i] = string
                break
            }
        }

        return arr
    }

    fun factorial(num: Int): Int {
        return if (num == 1) num
        else factorial(num - 1) + num
    }
}