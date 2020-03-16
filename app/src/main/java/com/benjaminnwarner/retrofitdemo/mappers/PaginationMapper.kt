package com.benjaminnwarner.retrofitdemo.mappers

import com.benjaminnwarner.retrofitdemo.models.Pagination
import com.benjaminnwarner.retrofitdemo.repository.pagination.PaginationResponse


object PaginationMapper : IMapper<PaginationResponse, Pagination> {
    override fun map(input: PaginationResponse): Pagination {
        return Pagination(
            total = input.total,
            offset = input.offset,
            limit = input.limit
        )
    }
}
