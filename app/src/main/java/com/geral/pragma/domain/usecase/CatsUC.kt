package com.geral.pragma.domain.usecase

import com.geral.pragma.domain.Cat
import com.geral.pragma.domain.common.Result
import com.geral.pragma.domain.repository.CatRepository

class CatsUC(
    private val CatsRepository: CatRepository
) {
    suspend fun getAllCats(): Result<List<Cat>> =
        CatsRepository.getAllCats()
}
