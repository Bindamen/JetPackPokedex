package com.example.myapplication.Model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AbilitiesItem(
    @SerializedName("abilityId")
    val abilityId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("text")
    val text: String
)