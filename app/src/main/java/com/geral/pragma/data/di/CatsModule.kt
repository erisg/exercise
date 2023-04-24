package com.geral.pragma.data.di

import com.geral.pragma.data.remote.CatsApi
import com.geral.pragma.data.repository.CatsRepositoryImpl
import com.geral.pragma.domain.repository.CatRepository
import com.geral.pragma.domain.usecase.CatsUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object CatsModule {

    @Provides
    @ViewModelScoped
    fun getCharacterDetailUCProvider(
        catRepository: CatRepository
    ): CatsUC = CatsUC(catRepository)

    @Provides
    @ViewModelScoped
    fun characterDetailRepositoryProvider(
        characterDetailApi: CatsApi
    ): CatRepository = CatsRepositoryImpl(characterDetailApi)

    @Provides
    @ViewModelScoped
    fun characterDetailApiProvider(
        retrofit: Retrofit
    ): CatsApi = retrofit.create(CatsApi::class.java)
}
