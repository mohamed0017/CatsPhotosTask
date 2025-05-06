package com.personal.myapplication.domain

import com.personal.myapplication.domain.usecase.CatsPhotosUseCase
import com.personal.myapplication.domain.usecase.CatsPhotosUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCatsPhotosUseCase(
        impl: CatsPhotosUseCaseImpl
    ): CatsPhotosUseCase = impl
}