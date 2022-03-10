package com.example.myapplication.Model.Species


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("language")
    val language: LanguageXX,
    @SerializedName("name")
    val name: String
)