@file:Suppress("BlockingMethodInNonBlockingContext")

package com.example.myapplication.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.Model.PokemonItem
import com.example.myapplication.Utils.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class MainViewModel : ViewModel() {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    private val _detailviewState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)
    private val _abilityviewState = MutableStateFlow<AbilityViewState>(AbilityViewState.Loading)

    val pokemons = _viewState.asStateFlow()
    val pokemonDetails = _detailviewState.asStateFlow()
    val abilities = _abilityviewState.asStateFlow()



    // Help Format the Json
    val format = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }



    //Get all abilities
    fun getAbilities(context: Context) = viewModelScope.launch {
        try {
            //read the json
            val myJson = context.assets.open("abilities.json").bufferedReader().use {
                it.readText()
            }
            //format Json
            val abilityList = format.decodeFromString<List<AbilitiesItem>>(myJson)

            _abilityviewState.value = AbilityViewState.Success(abilityList)
        } catch (e:Exception){
            _abilityviewState.value = AbilityViewState.Error(e)
        }
    }

    //Get Species



    //Get all data from Pokedex.json
    fun getAllPokemons(context: Context) = viewModelScope.launch {

        try {
            //read Json File
            val myJson = context.assets.open("Pokedex.json").bufferedReader().use {
                it.readText()
            }
            // format the Json
            val pokemonList = format.decodeFromString<List<PokemonItem>>(myJson)
            _viewState.value = ViewState.Success(pokemonList)
        } catch (e: Exception) {
            _viewState.value = ViewState.Error(e)
        }
    }

    // get Book by ID

    fun getPokemonID(context: Context, idNo: String) = viewModelScope.launch {

        try {
            //read Json File
            val myJson = context.assets.open("Pokedex.json").bufferedReader().use {
                it.readText()
            }
            // format the Json
            val pokemonList = format.decodeFromString<List<PokemonItem>>(myJson)
                .first { it.id.toString().contentEquals(idNo) }
            _detailviewState.value = DetailViewState.Success(pokemonList)
        } catch (e: Exception) {
            _detailviewState.value = DetailViewState.Error(e)
        }
    }
}

