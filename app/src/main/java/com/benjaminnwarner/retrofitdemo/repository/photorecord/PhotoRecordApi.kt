package com.benjaminnwarner.retrofitdemo.repository.photorecord

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoRecordApi {
    @GET("photo_records")
    suspend fun getPhotoRecords(@Query("offset") offset: Int, @Query("limit") limit: Int): PhotoRecordListResponse

    companion object {
        fun create(): PhotoRecordApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("REDACTED")
                .build()

            return retrofit.create(PhotoRecordApi::class.java)
        }
    }
}
