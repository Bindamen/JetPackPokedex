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
    val search = remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val filterPokemonItem = remember { mutableStateOf("") }

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
                    value = search.value,
                    onValueChanged = { search.value = it }
                )
            }

            // Horizontal Scrollable Chip Group (optional)
            Row(
                modifier = Modifier
                    .padding(top = 15.dp, start = 8.dp, end = 8.dp, bottom = 15.dp)
                    .horizontalScroll(rememberScrollState())

            ) {
                for (type in getAllTypeCategories()) {
                    TypeFilterChip(
                        typeP = type.value,
                        onValueChanged = {
                            filterPokemonItem.value = it
                            search.value = it
                        }
                    )
                }
            }

            // Pokemon List
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp),
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                items(pokemonList.filter {
                    it.name.contains(search.value, ignoreCase = true) ||
                            it.type.toString().contains(search.value)
                }) { pokemon ->
                    ItemPokemonList(
                        pokemon.name,
                        pokemon.imageURL,
                        pokemon.type,
                        onItemClick = { actions.gotoPokemonDetails.invoke(pokemon.id.toString()) }
                    )
                }
            }
        }
    }
}


