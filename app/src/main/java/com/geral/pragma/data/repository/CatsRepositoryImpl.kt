package com.geral.pragma.data.repository

import com.geral.pragma.data.mappers.toCatDomain
import com.geral.pragma.data.remote.CatsApi
import com.geral.pragma.domain.Cat
import com.geral.pragma.domain.common.Result
import com.geral.pragma.domain.common.fold
import com.geral.pragma.domain.common.makeSafeRequest
import com.geral.pragma.domain.repository.CatRepository

class CatsRepositoryImpl(
    private val catsApi: CatsApi
) : CatRepository {
    override suspend fun getAllCats(): Result<List<Cat>> {
        val result = makeSafeRequest { catsApi.getAllCats() }
        return result.fold(
            onSuccess = {
                Result.Success(it.first().toCatDomain())
            },
            onError = { code, message ->
                Result.Error(code, message)
            },
            onException = {
                Result.Exception(it)
            }

        )
    }
}
