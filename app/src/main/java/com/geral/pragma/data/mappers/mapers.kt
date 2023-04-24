package com.geral.pragma.data.mappers

import com.geral.pragma.domain.Cat
import com.geral.pragma.data.models.Cat as DataCat

fun DataCat.toCatDomain(): List<Cat> {
    return listOf(
        Cat(
            breedName = breedName,
            origin = origin,
            affectionLevel = affectionLevel,
            intelligence = intelligence,
            imgUrl = imgUrl
        )
    )
}
