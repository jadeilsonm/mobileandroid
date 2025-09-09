package com.example.pokedex.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APICliente {
    private const val BASE_URL = "https://pokeapi.co/"

    val instance: APIInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }
}