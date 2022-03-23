package com.example.myapplication.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.View.PokemonDetailsScreen
import com.example.myapplication.View.PokemonListScreen
import com.example.myapplication.ViewModel.MainViewModel


object EndPoints {
    const val ID = "id"
}

@ExperimentalComposeUiApi
@Composable

fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    val context = LocalContext.current


    NavHost(navController, startDestination = Screen.PokemonList.route) {
        // Home
        composable(Screen.PokemonList.route) {
            val viewModel: MainViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            viewModel.getAllPokemons(context = context)
            PokemonListScreen(viewModel, actions)
        }


        // Task Details
        composable(
            "${Screen.Details.route}/{id}",
            arguments = listOf(navArgument(EndPoints.ID) { type = NavType.StringType })
        ) {

            val viewModel = hiltViewModel<MainViewModel>(it)
            val id = it.arguments?.getString(EndPoints.ID)
                ?: throw IllegalStateException("'Pokemon ID ' shouldn't be null")

            viewModel.getPokemonID(context = context, idNo = id)
            viewModel.getAbilities(context = context, idNo = id)
            PokemonDetailsScreen(viewModel, actions)


        }
    }
}


class MainActions(navController: NavController) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val gotoPokemonDetails: (String) -> Unit = { idNo ->
        navController.navigate("${Screen.Details.route}/$idNo")
    }

    val gotoPokemonList: () -> Unit = {
        navController.navigate(Screen.PokemonList.route)
    }
}





