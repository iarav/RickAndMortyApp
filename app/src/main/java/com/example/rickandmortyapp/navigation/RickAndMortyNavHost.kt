package com.example.rickandmortyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.characterdetails.presentation.view.CharacterDetailView
import com.example.home.presentation.view.CharactersView

@Composable
fun RickAndMortyNavHost(
    modifier: Modifier = Modifier,
    charactersView: CharactersView,
    characterDetailView: CharacterDetailView
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            charactersView.Render(
                onNavigateToCharacterDetails = { characterId ->
                    navController.navigateToCharacterDetails(characterId)
                }
            )
        }
        composable(
            route = CharacterDetails.routeWithArg,
            arguments = CharacterDetails.arguments
        ) { navBackStackEntry ->
            val characterId =
                navBackStackEntry.arguments?.getInt(CharacterDetails.CHARACTER_ID) ?: 0
            characterDetailView.Render(
                characterId = characterId,
                onBackButtonPressed = {
                    navController.popBackStack()
                },
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

fun NavHostController.navigateToCharacterDetails(characterId: Int) {
    this.navigateSingleTopTo("${CharacterDetails.route}/$characterId")
}
