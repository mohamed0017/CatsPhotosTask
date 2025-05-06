package com.personal.myapplication.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsPhotosApi {

    @GET("images/search")
    suspend fun getCatsPhotos(@Query("limit") limit: Int): Response<List<CatsPhotosResponse>>
}

