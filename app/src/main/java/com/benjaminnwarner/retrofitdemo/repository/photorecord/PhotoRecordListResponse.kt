package com.benjaminnwarner.retrofitdemo.repository.photorecord

import com.benjaminnwarner.retrofitdemo.repository.pagination.PaginationResponse

data class PhotoRecordListResponse (
    val photo_records: List<PhotoRecordResponse> = emptyList(),
    val pagination: PaginationResponse
)
