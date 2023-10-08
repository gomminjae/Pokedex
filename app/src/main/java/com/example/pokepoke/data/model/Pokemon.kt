package com.example.pokepoke.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Pokemon(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "sprites") val sprites: PokemonSprites
)

@JsonClass(generateAdapter = true)
data class PokemonSprites(
    @Json(name = "front_default") val frontDefault: String
)