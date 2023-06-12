package com.example.myapplication.Utils


import androidx.compose.ui.graphics.Color
import com.example.myapplication.R
import com.example.myapplication.ui.theme.*
import java.util.*

fun parseTypeToColor(type: String): Color {

    return when(type.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "feu" -> TypeFire
        "eau" -> TypeWater
        "electric" -> TypeElectric
        "plante" -> TypeGrass
        "glace" -> TypeIce
        "combat" -> TypeFighting
        "poison" -> TypePoison
        "sol" -> TypeGround
        "vol" -> TypeFlying
        "psy" -> TypePsychic
        "insecte" -> TypeBug
        "roche" -> TypeRock
        "spectre" -> TypeGhost
        "dragon" -> TypeDragon
        "ténèbres" -> TypeDark
        "acier" -> TypeSteel
        "fée" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(statName: String): Color {
    return when (statName) {
        "HP" -> HPColor
        "Attack" -> AtkColor
        "Defense" -> DefColor
        "SpAttack" -> SpAtkColor
        "SpDefense" -> SpDefColor
        "Speed" -> SpdColor
        "BaseTotal" -> BaseColor
        else -> Color.White
    }
}

        fun parseStatToAbbr(statName: String): String {
            return when (statName){
                "HP" -> "HP"
                "Attack" -> "Atk"
                "Defense" -> "Def"
                "SpAttack" -> "SpA"
                "SpDefense" -> "SpD"
                "Speed" -> "Spd"
                "BaseTotal" -> "Tot"
                else -> ""

            }
        }

fun parseGenToId(gen:Int): Int {
    return when (gen){
        1 -> R.drawable.gen1
        2 -> R.drawable.gen2
        3 -> R.drawable.gen3
        4 -> R.drawable.gen4
        5 -> R.drawable.gen5
        6 -> R.drawable.gen6
        7 -> R.drawable.gen7
        8 -> R.drawable.gen8

        else -> R.drawable.gen1
    }
}