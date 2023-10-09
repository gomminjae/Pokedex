package com.example.pokepoke.ui.Home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel

import com.example.pokepoke.data.api.PokemonListItem
import com.example.pokepoke.data.api.PokemonListResponse
import com.example.pokepoke.data.model.Pokemon
import com.example.pokepoke.data.repository.PokemonRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class PokemonViewModel(private val repository:  PokemonRepository): ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonListItem>>()
    val pokemonList: LiveData<List<PokemonListItem>> = _pokemonList

    private val _pokemonDetail = MutableLiveData<Pokemon>()
    val pokemonDetail: LiveData<Pokemon> = _pokemonDetail

    val error = MutableLiveData<String>()

    fun getPokemonList() {
        repository.getPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful) {
                    val pokemonList = response.body()?.results
                    if (pokemonList != null) {
                        _pokemonList.postValue(pokemonList)
                    } else {
                        error.postValue("Pokemon list is empty")
                    }
                } else {
                    error.postValue("Network error")
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                error.postValue(t.message ?: "An error occurred")
            }
        })
    }

    fun getPokemonDetail(endpoint: String) {
        repository.getPokemonDetail(endpoint).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    val pokemon = response.body()
                    if (pokemon != null) {
                        _pokemonDetail.postValue(pokemon)
                    } else {
                        error.postValue("Pokemon data is null")
                    }
                } else {
                    error.postValue("Network error")
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                error.postValue(t.message ?: "An error occurred")
            }
        })
    }
}