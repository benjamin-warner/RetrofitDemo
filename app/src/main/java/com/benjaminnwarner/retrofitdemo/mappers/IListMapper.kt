package com.benjaminnwarner.retrofitdemo.mappers

interface IListMapper<A, B> {
    fun mapList(input: List<A>): List<B>
}
