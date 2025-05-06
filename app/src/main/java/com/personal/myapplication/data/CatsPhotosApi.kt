package com.personal.myapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface CatsPhotosApi {

    @GET("images/search")
    suspend fun getCatsPhotos(): Response<List<CatsPhotosResponse>>
}

