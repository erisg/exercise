package com.geral.pragma.data.models

import com.squareup.moshi.Json

data class Cat(
    @Json(name = "breedName")
    val breedName: String,
    @Json(name = "origin")
    val origin: String,
    @Json(name = "affectionLevel")
    val affectionLevel: String,
    @Json(name = "intelligence")
    val intelligence: String,
    @Json(name = "imgUrl")
    val imgUrl: String
)
