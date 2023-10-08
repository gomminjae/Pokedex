package com.example.pokepoke.data.api

import com.example.pokepoke.data.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("v2/pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>

    @GET("v2/pokemon")
    fun getPokemonList(): Call<PokemonListResponse>

    @GET("v2/pokemon/{endpoint}/")
    fun getPokemonDetail(@Path("endpoint") endpoint: String): Call<Pokemon>

}

@JsonClass(generateAdapter = true)
data class PokemonListResponse(
    @Json(name = "results") val results: List<PokemonListItem>
)

@JsonClass(generateAdapter = true)
data class PokemonListItem(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)