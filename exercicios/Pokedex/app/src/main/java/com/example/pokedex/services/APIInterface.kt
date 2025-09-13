package com.example.pokedex.services

import com.example.pokedex.models.Paginate
import com.example.pokedex.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {

    @GET("api/v2/pokemon?limit=100000&offset=0")
    suspend fun getPokemons(): Response<Paginate>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonByName(@Path(value = "name") name: String): Response<Pokemon>
}