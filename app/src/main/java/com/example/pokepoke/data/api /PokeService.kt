package com.example.pokepoke.data.api

import com.example.pokepoke.data.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPIService {
    @GET("api/v2/pokemon/{pokemonname}")
    fun getPokemonInfo(@Path("pokemonName") pokemonName: String): Call<Pokemon>
}



class PokeService {
}