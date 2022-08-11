package com.example.core.mapper

interface TwiceMapper<FirstInput, SecondInput, Output> {

    fun map(firstInput: FirstInput, secondInput: SecondInput): Output
}