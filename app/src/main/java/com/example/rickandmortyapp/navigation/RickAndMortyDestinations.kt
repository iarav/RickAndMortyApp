package com.example.rickandmortyapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface RickAndMortyDestinations {
    val route: String
}

object Home : RickAndMortyDestinations {
    override val route: String
        get() = "home"
}

object CharacterDetails : RickAndMortyDestinations {
    override val route: String
        get() = "character_details"
    const val CHARACTER_ID = "characterId"
    val routeWithArg = "$route/{$CHARACTER_ID}"
    val arguments = listOf(
        navArgument(CHARACTER_ID) { type = NavType.IntType }
    )
}