package com.example.pokedex.services

import android.R
import com.example.pokedex.models.Paginate
import com.google.gson.internal.NumberLimits
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET("api/v2/pokemon?limit=100000&offset=0")
    suspend fun getPokemons(): Response<Paginate>
}