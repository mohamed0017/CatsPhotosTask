package com.personal.myapplication.data.repos

import com.personal.myapplication.data.CatsPhotosApi
import com.personal.myapplication.data.CatsPhotosResponse
import com.personal.myapplication.domain.repos.CatsPhotosRepo
import javax.inject.Inject

class CatsPhotosRepoImpl @Inject constructor(private val catsPhotosApi: CatsPhotosApi) :
    CatsPhotosRepo {
    override suspend fun getPhotos(limit: Int): Result<List<CatsPhotosResponse>> {

        try {
            val response = catsPhotosApi.getCatsPhotos(limit)

            return if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {

                return when (response.code()) {
                    404 -> {
                        Result.failure(Exception("Error: 404 Not Found"))
                    }

                    500 -> {
                        Result.failure(Exception("Error: 500 Server Error"))
                    }

                    else -> {
                        Result.failure(Exception("Error:  Unknown Error"))
                    }
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure(Exception("No Internet"))

        }
    }


}