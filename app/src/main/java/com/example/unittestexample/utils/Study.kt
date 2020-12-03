package com.example.unittestexample.utils

import java.lang.IllegalArgumentException

class Study {
    constructor(price: Int) {
        if (price < 0) {
            throw IllegalArgumentException("The price cannot be below zero")
        }
    }
}