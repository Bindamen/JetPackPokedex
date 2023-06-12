package com.example.myapplication.Component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Model.AbilitiesItem
import com.example.myapplication.Model.PokemonItem
import com.example.myapplication.Utils.*
import com.example.myapplication.ViewModel.MainViewModel
import com.example.myapplication.ui.theme.text
import kotlinx.coroutines.flow.forEach

@Composable
fun PokemonTech(
    viewModel: MainViewModel,
    type: List<String>,
    id: Int


) {
    when (val result = viewModel.abilities.value) {

        AbilityViewState.Empty -> Text("No Results Found!")
        is AbilityViewState.Error -> Text(text = "Error found: ${result.exception}")
        AbilityViewState.Loading -> Text(text = "Loading")
        is AbilityViewState.Success -> {

            val abilitiesItem = result.data

            abilitiesItem.forEach {
                if(it.id == id){
                    Column(modifier = Modifier.padding(15.dp)) {
                        Row(modifier = Modifier.align(Alignment.Start)) {
                            Text(
                                text = it.name.capitalize(),
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Bold,
                                color = parseTypeToColor(type[0])
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .align(Alignment.Start)
                        ) {
                            Text(
                                text = it.text.replace(oldValue = "\n", newValue = " "),
                                textAlign = TextAlign.Start
                            )
                        }
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                }

            }

        }
    }
}