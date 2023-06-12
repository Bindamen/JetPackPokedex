package com.example.myapplication.Utils

import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.Model.PokemonItem



sealed class ViewStateAb {
    object Empty: ViewStateAb()
    object Loading: ViewStateAb()
    data class  Success(val data : List<AbilitiesItem>): ViewStateAb()
    data class  Error(val exception: Throwable): ViewStateAb()
}