package com.example.myapplication.Navigation

import androidx.annotation.StringRes
import com.example.myapplication.R

sealed class Screen(val route: String, @StringRes val id: Int) {
    object PokemonList : Screen("pokemon_list", R.string.text_PokemonList)
    object Details : Screen("pokemon_details", R.string.text_PokemonDetails)
}
