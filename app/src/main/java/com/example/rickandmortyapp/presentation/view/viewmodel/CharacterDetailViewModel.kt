package com.example.rickandmortyapp.presentation.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.mapper.CharacterDetailsPresentationMapper
import com.example.rickandmortyapp.domain.usecase.GetCharacterByIdUseCase
import com.example.rickandmortyapp.presentation.model.CharacterUiItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CharacterDetailUiState(
    val isLoading: Boolean = false,
    val characterDetails: CharacterUiItem? = null,
    val errorMessage: String? = null
)

sealed class CharacterDetailAction {
    data class FetchCharacterDetails(val characterId: Int) : CharacterDetailAction()
}

class CharacterDetailViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val characterDetailsPresentationMapper: CharacterDetailsPresentationMapper
) : ViewModel() {

    private val _characterDetailUiState = MutableStateFlow(CharacterDetailUiState())
    val characterDetailUiState: StateFlow<CharacterDetailUiState> =
        _characterDetailUiState.asStateFlow()

    fun sendAction(action: CharacterDetailAction): Any {
        return when (action) {
            is CharacterDetailAction.FetchCharacterDetails -> fetchCharacterDetails(action.characterId)
        }
    }

    private fun fetchCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            _characterDetailUiState.update { it.copy(isLoading = true) }
            try {
                if (characterId != 0) {
                    getCharacterByIdUseCase(characterId).collect { characterDetails ->
                        _characterDetailUiState.update {
                            it.copy(
                                isLoading = false,
                                characterDetails = characterDetailsPresentationMapper.map(
                                    characterDetails
                                )
                            )
                        }
                    }
                } else {
                    _characterDetailUiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "Character ID cannot be 0"
                        )
                    }
                }
            } catch (e: Exception) {
                _characterDetailUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message
                    )
                }
            }
        }
    }
}
