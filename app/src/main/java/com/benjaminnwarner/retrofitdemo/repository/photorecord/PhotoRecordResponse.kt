package com.benjaminnwarner.retrofitdemo.repository.photorecord

data class PhotoRecordResponse(
    val comment: String,
    val photo_type: String,
    val image_url: String,
    val recorded_at: String
)
