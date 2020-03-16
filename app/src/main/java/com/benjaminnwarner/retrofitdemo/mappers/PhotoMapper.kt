package com.benjaminnwarner.retrofitdemo.mappers

import com.benjaminnwarner.retrofitdemo.enums.PhotoType
import com.benjaminnwarner.retrofitdemo.models.PhotoRecord
import com.benjaminnwarner.retrofitdemo.repository.photorecord.PhotoRecordResponse
import java.util.*

object PhotoMapper:
    IListMapper<PhotoRecordResponse, PhotoRecord>,
    IMapper<PhotoRecordResponse, PhotoRecord> {

    override fun mapList(input: List<PhotoRecordResponse>): List<PhotoRecord> {
        return input.map { map(it) }
    }

    override fun map(input: PhotoRecordResponse): PhotoRecord {
        return PhotoRecord(
            imageUrl = input.image_url,
            comment = input.comment,
            photoType = photoType(input.photo_type),
            recordedAt = Date()
        )
    }

    private fun photoType(type: String): PhotoType = when(type) {
        "family" -> PhotoType.FAMILY
        "vacation" -> PhotoType.VACATION
        "flowers" -> PhotoType.FLOWERS
        else -> PhotoType.FAMILY
    }
}
