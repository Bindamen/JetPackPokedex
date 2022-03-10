package com.example.myapplication.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.Utils.AbilityViewState
import com.example.myapplication.ViewModel.MainViewModel

@Composable
fun AbilityDetails(viewModel: MainViewModel){
    when (val abiResult = viewModel.abilities.value){

        AbilityViewState.Empty -> Text("No Results Found!")
        is AbilityViewState.Error -> Text(text = "Error found: ${abiResult.Eexception}")
        AbilityViewState.Loading -> Text(text = "Loading")
        is AbilityViewState.Success -> {
            val ability = abiResult.datab

            LazyColumn{
                item {
                    ability.AbilityName
                    ability.AbilityDesc
                }
            }
        }
    }
}