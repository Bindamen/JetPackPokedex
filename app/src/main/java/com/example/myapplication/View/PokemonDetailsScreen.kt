package com.example.myapplication.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.myapplication.Component.PokemonDetailCard
import com.example.myapplication.Component.TopBar
import com.example.myapplication.Navigation.MainActions
import com.example.myapplication.R
import com.example.myapplication.Utils.DetailViewState
import com.example.myapplication.ViewModel.MainViewModel

import com.example.myapplication.Utils.parseTypeToColor
import java.lang.reflect.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsScreen(viewModel: MainViewModel,actions: MainActions) {
    Scaffold(
        topBar = {
            TopBar(
                name = stringResource(id = R.string.text_PokemonDetails),
                action = actions
            )
        }
    ) {
        PokemonDetails(viewModel = viewModel)
    }
}




@Composable
fun PokemonDetails(viewModel: MainViewModel) {

    when (val result = viewModel.pokemonDetails.value) {

        DetailViewState.Empty -> Text("No Results Found!")
        is DetailViewState.Error -> Text(text = "Error found: ${result.exception}")
        DetailViewState.Loading -> Text(text = "Loading")
        is DetailViewState.Success -> {

            val pokemon = result.data

            LazyColumn {
                item {
                    PokemonDetailCard(
                        pokemon.name,
                        pokemon.type,
                        pokemon.imageURL,
                        pokemon.weight,
                        pokemon.height,
                        pokemon.id,
                        pokemon.HP,
                        pokemon.Attack,
                        pokemon.BaseTotal,
                        pokemon.Defense,
                        pokemon.SpDefense,
                        pokemon.Speed,
                        pokemon.SpAttack,
                        pokemon.against_acier,
                        pokemon.against_combat,
                        pokemon.against_eau,
                        pokemon.against_dragon,
                        pokemon.against_fée,
                        pokemon.against_electric,
                        pokemon.against_feu,
                        pokemon.against_glace,
                        pokemon.against_insecte,
                        pokemon.against_normal,
                        pokemon.against_plante,
                        pokemon.against_poison,
                        pokemon.against_psy,
                        pokemon.against_roche,
                        pokemon.against_sol,
                        pokemon.against_spectre,
                        pokemon.against_ténèbres,
                        pokemon.against_vol,
                        pokemon.Gen,
                        pokemon.Male,
                        pokemon.Female,
                        pokemon.Game,
                        pokemon.Region,

                    )
                }
            }
        }
    }
}
