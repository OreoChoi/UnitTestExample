package com.example.unittestexample.utils

class Utils {

    //문자열을 2개씩 자릅니다.
    fun cutTwoWord(str: String): Array<String> {
        val arr: Array<String> = Array(str.length / 2 + 1) { "" }
        var string:String = str
        for(i in arr.indices){
            if (string.length > 1) {   //문자열 2자리 이상 시
                arr[i] = string.substring(0, 2)
                string = string.substring(2)
            }else{
                arr[i] = string
                break
            }
        }

        return arr
    }
}