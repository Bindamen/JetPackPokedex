package com.example.myapplication.Model.Species


import com.google.gson.annotations.SerializedName

data class PokemonX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)