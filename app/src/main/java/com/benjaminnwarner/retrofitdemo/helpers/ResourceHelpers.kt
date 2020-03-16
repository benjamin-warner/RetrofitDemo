package com.benjaminnwarner.retrofitdemo.helpers

import com.benjaminnwarner.retrofitdemo.R
import com.benjaminnwarner.retrofitdemo.enums.PhotoType

object ResourceHelpers {

    fun photoTypeStringId(type: PhotoType): Int = when(type) {
        PhotoType.FAMILY -> R.string.photo_family
        PhotoType.VACATION -> R.string.photo_vacation
        PhotoType.FLOWERS -> R.string.photo_flowers
    }

    fun photoTagColor(type: PhotoType): Int = when(type) {
        PhotoType.FAMILY -> R.color.photo_family_tag
        PhotoType.VACATION -> R.color.photo_vacation_tag
        PhotoType.FLOWERS -> R.color.photo_flowers_tag
    }
}
