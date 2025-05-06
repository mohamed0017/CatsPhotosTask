package com.personal.myapplication.domain.usecase

import com.personal.myapplication.data.CatsPhotosResponse
import com.personal.myapplication.domain.repos.CatsPhotosRepo
import javax.inject.Inject

class CatsPhotosUseCaseImpl @Inject constructor(private val catsPhotosRepo: CatsPhotosRepo) : CatsPhotosUseCase{

    override suspend fun getPhotos(limit:Int): Result<List<CatsPhotosResponse>> {
       return catsPhotosRepo.getPhotos(limit)
    }


}