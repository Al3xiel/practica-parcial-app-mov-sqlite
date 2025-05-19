package com.example.practica_parcial_swqlite.model.response

import com.example.practica_parcial_swqlite.model.beans.Hero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("search/{hero_name}")
    suspend fun getHeroByName(@Path("hero_name") heroName: String): Response<Hero>
}