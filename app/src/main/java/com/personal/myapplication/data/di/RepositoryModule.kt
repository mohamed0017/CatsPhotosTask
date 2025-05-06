package com.personal.myapplication.data.di

import com.personal.myapplication.data.repos.CatsPhotosRepoImpl
import com.personal.myapplication.domain.repos.CatsPhotosRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCatsPhotosRepository(
        impl: CatsPhotosRepoImpl
    ): CatsPhotosRepo = impl
}