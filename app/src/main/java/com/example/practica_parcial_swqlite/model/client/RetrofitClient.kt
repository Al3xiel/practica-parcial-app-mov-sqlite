package com.example.practica_parcial_swqlite.model.client

import com.example.practica_parcial_swqlite.model.response.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.superheroapi.com/api.php/10157703717092094/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebService::class.java)
    }
}