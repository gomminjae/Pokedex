package com.example.pokepoke
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel

import com.example.pokepoke.data.api.PokemonListItem
import com.example.pokepoke.data.model.Pokemon
import com.example.pokepoke.data.repository.PokemonRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Response

class PokemonViewModel(private val repository:  PokemonRepository): ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonListItem>>()
    val pokemonList: LiveData<List<PokemonListItem>> = _pokemonList

    private val _pokemonDetail = MutableLiveData<Pokemon>()
    val pokemonDetail: LiveData<Pokemon> = _pokemonDetail

    val error = MutableLiveData<String>()

    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPokemonList()
                if(response.isSuccessful) {
                    val pokemonList = response.body()?.results
                    if(pokemonList != null) {
                        _pokemonList.postValue(pokemonList)
                    } else {
                        error.postValue("List is empty")
                    }
                } else {
                    error.postValue("error")
                }
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

    fun getPokemonDetail(endpoint: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPokemonDetail(endpoint)
                if(response.isSuccessful) {
                    val pokemon = response.body()
                    if(pokemon != nuil) {
                        _pokemonDetail.postValue(pokemon)
                    } else {
                        error.postValue("Pokemon detail error")
                    }
                } else {
                    error.postValue("pokemon null")
                }
            } catch(e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}