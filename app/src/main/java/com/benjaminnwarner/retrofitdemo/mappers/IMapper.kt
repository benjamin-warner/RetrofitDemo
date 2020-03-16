package com.benjaminnwarner.retrofitdemo.mappers

interface IMapper<A, B> {
    fun map(input: A): B
}
