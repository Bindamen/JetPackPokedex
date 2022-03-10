package com.example.myapplication.Utils

import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.Model.PokemonItem


sealed class ViewState {
    object Empty: ViewState()
    object Loading: ViewState()
    data class  Success(val data : List<PokemonItem>): ViewState()
    data class  Error(val exception: Throwable): ViewState()
}
