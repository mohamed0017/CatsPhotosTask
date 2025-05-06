package com.personal.myapplication.data.repos

import com.personal.myapplication.data.CatsPhotosApi
import com.personal.myapplication.data.CatsPhotosResponse
import com.personal.myapplication.domain.repos.CatsPhotosRepo
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

class CatsPhotosRepoImpl @Inject constructor(private val catsPhotosApi: CatsPhotosApi) : CatsPhotosRepo {
    override suspend fun getPhotos(): Result<List<CatsPhotosResponse>> {
        val response = catsPhotosApi.getCatsPhotos()

        return if (response.isSuccessful) {
            Result.success(response.body() ?: emptyList())
        } else {

            return when (response.code()) {
                404 -> {
                    Result.failure(Exception())
                }

                500 -> {
                    Result.failure(Exception())
                }

                else -> {
                    Result.failure(Exception())
                }
            }

        }
    }


}