package com.example.pokepoke.data.repository

import com.example.pokepoke.data.api.PokeApiService
import com.example.pokepoke.data.api.PokemonListResponse
import com.example.pokepoke.data.model.Pokemon
import retrofit2.Call
import retrofit2.Response

class PokemonRepository(private val pokemonAPIService: PokeApiService) {

    suspend fun getPokemonList(): Response<PokemonListResponse> {
        return pokemonAPIService.getPokemonList()
    }

    suspend fun getPokemonDetail(endpoint: String): Response<Pokemon> {
        return pokemonAPIService.getPokemonDetail(endpoint)
    }
}