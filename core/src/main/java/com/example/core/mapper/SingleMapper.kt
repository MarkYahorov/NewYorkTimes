package com.example.core.mapper

interface SingleMapper<Input, Output> {

    fun map(input: Input): Output
}