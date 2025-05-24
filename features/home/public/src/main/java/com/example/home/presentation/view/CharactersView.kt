package com.example.home.presentation.view

import androidx.compose.runtime.Composable
import com.example.home.presentation.viewmodel.CharactersViewModel
import org.koin.androidx.compose.koinViewModel

abstract class CharactersView {
    @Composable
    abstract fun CharactersListView(
        viewModel: CharactersViewModel,
        onNavigateToCharacterDetails: (Int) -> Unit
    )

    @Composable
    fun Render(
        onNavigateToCharacterDetails: (Int) -> Unit = {},
    ) {
        val viewModel: CharactersViewModel = koinViewModel()
        CharactersListView(viewModel, onNavigateToCharacterDetails)
    }
}