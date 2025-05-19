package com.example.practica_parcial_swqlite.model.beans

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("results") val results: List<Hero>?
)