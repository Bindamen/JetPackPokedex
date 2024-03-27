package com.example.myapplication.View


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Component.*
import com.example.myapplication.Model.PokemonItem
import com.example.myapplication.Navigation.MainActions
import com.example.myapplication.R
import com.example.myapplication.Utils.ViewState
import com.example.myapplication.ViewModel.MainViewModel
import kotlin.reflect.typeOf

@SuppressLint("StateFlowValueCalledInComposition")
@ExperimentalComposeUiApi
@Composable
fun PokemonListScreen(viewModel: MainViewModel, actions: MainActions) {
    when(val result = viewModel.pokemons.value){
        ViewState.Empty -> Text("No Results Found!")
        is ViewState.Error -> Text(text = "Error found: ${result.exception}")
        ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> {
            PokemonList(result.data, actions)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PokemonList(pokemonList: List<PokemonItem>, actions: MainActions) {
    val searchQuery = remember { mutableStateOf("") }
    val selectedType = remember { mutableStateOf<String?>(null) } // Use null when no type is selected
    val listState = rememberLazyListState()

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            // Image and Search Bar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                    contentDescription = "Pokemon",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextInputField(
                    label = stringResource(R.string.text_search),
                    value = searchQuery.value,
                    onValueChanged = { searchQuery.value = it }
                )
            }
            // Horizontal Scrollable Chip Group (optional)
            Row(
                modifier = Modifier
                    .padding(top = 15.dp, start = 8.dp, end = 8.dp, bottom = 15.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                for (type in getAllTypeCategories()) {
                    val isSelected = selectedType.value == type.value
                    TypeFilterChip(
                        typeP = type.value,
                        onValueChanged = {
                            if (isSelected) {
                                // If the type is already selected, unselect it
                                selectedType.value = null
                            } else {
                                // Otherwise, update the selected type
                                selectedType.value = it
                            }


                            // Do not automatically set the search query when selecting a type
                        }
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(2.dp),
                state = listState,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                val filteredList = pokemonList.filter { pokemon ->
                    val nameMatch = pokemon.name.contains(searchQuery.value, ignoreCase = true)
                    val typeMatch = selectedType.value?.let {
                        pokemon.type.toString().contains(it, ignoreCase = true)
                    } ?: true // If no type is selected, typeMatch is always true
                    nameMatch && typeMatch // Use logical AND to ensure both conditions are met
                }


                items((filteredList.size + 1) / 2) { rowIndex ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val index1 = rowIndex * 2
                        val index2 = index1 + 1

                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            if (index1 < filteredList.size) {
                                val pokemon1 = filteredList[index1]
                                ItemPokemonList(
                                    pokemon1.name,
                                    pokemon1.imageURL,
                                    pokemon1.type,
                                    onItemClick = { actions.gotoPokemonDetails.invoke(pokemon1.id.toString()) }
                                )
                            }
                        }

                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            if (index2 < filteredList.size) {
                                val pokemon2 = filteredList[index2]
                                ItemPokemonList(
                                    pokemon2.name,
                                    pokemon2.imageURL,
                                    pokemon2.type,
                                    onItemClick = { actions.gotoPokemonDetails.invoke(pokemon2.id.toString()) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


