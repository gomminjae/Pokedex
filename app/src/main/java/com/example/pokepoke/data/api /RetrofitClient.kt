package com.example.pokepoke.data.api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



object RetrofitClient {
    private const val baseUrl = "https://pokeapi.co/api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

}