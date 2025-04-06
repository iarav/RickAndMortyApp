package com.example.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.presentation.model.CharacterUiItem
import kotlinx.coroutines.flow.StateFlow

sealed class CharacterAction {
    data object FetchAllCharacters : CharacterAction()
}

data class CharactersUiState(
    val isLoading: Boolean = false,
    val charactersList: List<CharacterUiItem>? = null,
    val errorMessage: Int? = null
)

abstract class CharactersViewModel : ViewModel() {
    abstract val charactersUiState: StateFlow<CharactersUiState>

    abstract fun sendAction(action: CharacterAction) : Any
}