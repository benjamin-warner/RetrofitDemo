package com.benjaminnwarner.retrofitdemo.models

import com.benjaminnwarner.retrofitdemo.enums.PhotoType
import java.util.*

data class PhotoRecord(
    val imageUrl: String,
    val comment: String,
    val recordedAt: Date,
    val photoType: PhotoType
)
