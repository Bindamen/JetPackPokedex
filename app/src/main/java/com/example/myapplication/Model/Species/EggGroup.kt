package com.example.myapplication.Model.Species


import com.google.gson.annotations.SerializedName

data class EggGroup(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)