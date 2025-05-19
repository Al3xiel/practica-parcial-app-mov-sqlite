package com.example.practica_parcial_swqlite.model.beans

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("id") val id: String,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: Appearance,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: Image
) {
    val fullName: String get() = biography.fullName
    val gender: String get() = appearance.gender
    val race: String get() = appearance.race
    val intelligence: String get() = powerstats.intelligence
    val imageUrl: String get() = image.url
}

data class Biography(
    @SerializedName("full-name") val fullName: String
)

data class Appearance(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String
)

data class PowerStats(
    @SerializedName("intelligence") val intelligence: String
)

data class Image(
    @SerializedName("url") val url: String
)