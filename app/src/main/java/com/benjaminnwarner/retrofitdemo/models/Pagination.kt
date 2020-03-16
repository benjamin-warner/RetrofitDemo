package com.benjaminnwarner.retrofitdemo.models

data class Pagination(
    val total: Int,
    val offset: Int,
    val limit: Int
)
