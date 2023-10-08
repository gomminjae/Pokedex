package com.example.pokepoke.data.model


data class Pokemon(
    val id: Int,
    val name: String,
    val type: List<String>,
    val abilities: List<String>
)
