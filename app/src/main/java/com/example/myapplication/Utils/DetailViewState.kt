package com.example.myapplication.Utils

import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.Model.PokemonItem


sealed class DetailViewState {
    object Empty: DetailViewState()
    object Loading: DetailViewState()
    data class  Success(val data: PokemonItem) : DetailViewState()
    data class  Error(val exception: Throwable): DetailViewState()
}


