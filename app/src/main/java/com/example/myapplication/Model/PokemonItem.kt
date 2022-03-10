package com.example.myapplication.Model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class PokemonItem(
    @SerializedName("against_acier")
     val against_acier: Double =0.0,
    @SerializedName("against_combat")
     val against_combat: Double =0.0,
    @SerializedName("against_dragon")
     val against_dragon: Double =0.0,
    @SerializedName("against_eau")
     val against_eau: Double =0.0,
    @SerializedName("against_electric")
     val against_electric: Double =0.0,
    @SerializedName("against_feu")
     val against_feu: Double =0.0,
    @SerializedName("against_fée")
     val against_fée: Double =0.0,
    @SerializedName("against_glace")
     val against_glace: Double =0.0,
    @SerializedName("against_insecte")
     val against_insecte: Double =0.0,
    @SerializedName("against_normal")
     val against_normal: Double =0.0,
    @SerializedName("against_plante")
     val against_plante: Double =0.0,
    @SerializedName("against_poison")
     val against_poison: Double =0.0,
    @SerializedName("against_psy")
     val against_psy: Double =0.0,
    @SerializedName("against_roche")
     val against_roche: Double =0.0,
    @SerializedName("against_sol")
     val against_sol: Double =0.0,
    @SerializedName("against_spectre")
     val against_spectre: Double =0.0,
    @SerializedName("against_ténèbres")
     val against_ténèbres: Double =0.0,
    @SerializedName("against_vol")
     val against_vol: Double =0.0,
    @SerializedName("Attack")
     val Attack: Int,
    @SerializedName("BaseTotal")
     val BaseTotal: Int ,
    @SerializedName("Defense")
     val Defense: Int ,
    @SerializedName("evolution_chain_id")
     val evolutionChainId: Int = 0,
    @SerializedName("female")
     val Female: Double =0.0,
    @SerializedName("Game")
     val Game: String ="",
    @SerializedName("Gen")
     val Gen: Int = 0,
    @SerializedName("HP")
    val HP: Int,
    @SerializedName("habitat_id")
     val habitatId: Int = 0 ,
    @SerializedName("height")
    val height: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageURL")
     val imageURL: String ,
    @SerializedName("LangEN")
     val langEN: String = "" ,
    @SerializedName("male")
     val Male: Double = 0.0,
    @SerializedName("name")
     val name: String ,
    @SerializedName("Region")
     val Region: String = "" ,
    @SerializedName("shinyId")
     val shinyId: String ,
    @SerializedName("SpAttack")
     val SpAttack: Int ,
    @SerializedName("SpDefense")
     val SpDefense: Int ,
    @SerializedName("Species")
     val species: String = "" ,
    @SerializedName("Speed")
     val Speed: Int,
    @SerializedName("type")
     val type: List<String> = emptyList(),
    @SerializedName("weaknesses")
     val weaknesses: List<String> = emptyList(),
    @SerializedName("weight")
     val weight: Double
)