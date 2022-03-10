package com.example.myapplication.Model


import com.google.gson.annotations.SerializedName

data class AbilitiesItem(
    @SerializedName("abilityId")
    val abilityId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val AbilityName: String,
    @SerializedName("text")
    val AbilityDesc: String
)