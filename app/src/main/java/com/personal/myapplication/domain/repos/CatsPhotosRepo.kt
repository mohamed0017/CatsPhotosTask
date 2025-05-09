package com.personal.myapplication.domain.repos

import com.personal.myapplication.data.CatsPhotosResponse

interface CatsPhotosRepo {
    suspend fun getPhotos(limit: Int): Result<List<CatsPhotosResponse>>
}