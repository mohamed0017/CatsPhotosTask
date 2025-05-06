package com.personal.myapplication.data.di

import com.personal.myapplication.data.CatsPhotosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class APiModule {

    @Provides
    @Singleton
    fun provideCatsPhotosApi(retrofit: Retrofit): CatsPhotosApi {
        return retrofit.create<CatsPhotosApi>()
    }
}