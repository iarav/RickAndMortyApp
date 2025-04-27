package com.example.characterdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.presentation.model.CharacterUiItem
import kotlinx.coroutines.flow.StateFlow

data class CharacterDetailUiState(
    val isLoading: Boolean = false,
    val characterDetails: CharacterUiItem? = null,
    val errorMessage: Int? = null
)

sealed class CharacterDetailAction {
    data class FetchCharacterDetails(val characterId: Int) : CharacterDetailAction()
}

abstract class CharacterDetailViewModel : ViewModel() {
    abstract val characterDetailUiState: StateFlow<CharacterDetailUiState>
    abstract fun sendAction(action: CharacterDetailAction): Any
}
