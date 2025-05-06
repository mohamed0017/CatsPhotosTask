package com.personal.myapplication.domain.usecase

import com.personal.myapplication.data.CatsPhotosResponse

interface CatsPhotosUseCase{

    suspend fun getPhotos() : Result<List<CatsPhotosResponse>>
}