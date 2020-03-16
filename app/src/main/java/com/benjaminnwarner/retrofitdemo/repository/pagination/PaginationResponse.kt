package com.benjaminnwarner.retrofitdemo.repository.pagination

data class PaginationResponse(
    val total: Int,
    val offset: Int,
    val limit: Int
)
