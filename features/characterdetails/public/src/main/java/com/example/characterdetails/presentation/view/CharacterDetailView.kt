package com.example.characterdetails.presentation.view

import androidx.compose.runtime.Composable
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModel
import org.koin.androidx.compose.koinViewModel

abstract class CharacterDetailView {
    @Composable
    abstract fun CharacterDetails(
        characterId: Int,
        onBackButtonPressed: () -> Unit,
        viewModel: CharacterDetailViewModel
    )

    @Composable
    fun Render(characterId: Int = 0, onBackButtonPressed: () -> Unit = {}) {
        val viewModel: CharacterDetailViewModel = koinViewModel()
        CharacterDetails(
            characterId,
            onBackButtonPressed,
            viewModel
        )
    }
}
