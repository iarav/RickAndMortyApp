package com.example.characterdetails.presentation.view

import androidx.compose.runtime.Composable
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModel
import org.koin.androidx.compose.koinViewModel

abstract class CharacterDetailView {
    @Composable
    abstract fun CharacterDetails(
        characterId: Int,
        viewModel: CharacterDetailViewModel
    )

    @Composable
    fun Render(characterId: Int = 0) {
        val viewModel: CharacterDetailViewModel = koinViewModel()
        CharacterDetails(characterId, viewModel)
    }
}
