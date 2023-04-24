package com.geral.pragma.domain.repository

import com.geral.pragma.domain.Cat
import com.geral.pragma.domain.common.Result

interface CatRepository {
    suspend fun getAllCats(): Result<List<Cat>>
}