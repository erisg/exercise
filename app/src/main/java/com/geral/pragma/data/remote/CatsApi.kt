package com.geral.pragma.data.remote

import com.geral.pragma.data.models.Cat
import retrofit2.Response
import retrofit2.http.GET

interface CatsApi {
    @GET(CATS)
    suspend fun getAllCats(): Response<List<Cat>>
}

private const val CATS = "breeds"