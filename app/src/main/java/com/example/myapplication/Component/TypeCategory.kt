package com.example.myapplication.Component

import android.media.Image
import com.example.myapplication.Model.PokemonItem

enum class TypeCategory(val value: String){

    ACIER("acier"),
    ELECTRIC("electric"),
    PLANTE("plante"),
    POISON("poison"),
    FEE("fée"),
    TENEBRES("ténèbres"),
    FEU("feu"),
    EAU("eau"),
    SPECTRE("spectre"),
    COMBAT("combat"),
    NORMAL("normal"),
    GLACE("glace"),
    INSECTE("insecte"),
    PSY("psy"),
    ROCHE("roche"),
    SOL("sol"),
    VOL("vol"),
    DRAGON("dragon")

}

fun getAllTypeCategories():List<TypeCategory>{
    return listOf(TypeCategory.ACIER,TypeCategory.ELECTRIC,TypeCategory.PLANTE,TypeCategory.POISON,
    TypeCategory.FEE,TypeCategory.TENEBRES,TypeCategory.FEU,TypeCategory.EAU,TypeCategory.SPECTRE,
    TypeCategory.COMBAT,TypeCategory.NORMAL,TypeCategory.GLACE,TypeCategory.INSECTE,TypeCategory.PSY,
    TypeCategory.ROCHE,TypeCategory.SOL,TypeCategory.VOL,TypeCategory.DRAGON)
}

fun getTypeCategory(value: String): TypeCategory?{
    val map = TypeCategory.values().associateBy(TypeCategory::value)
    return map[value]
}
