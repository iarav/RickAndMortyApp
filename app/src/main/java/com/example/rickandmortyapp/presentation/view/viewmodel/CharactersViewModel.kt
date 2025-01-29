package com.example.rickandmortyapp.presentation.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.domain.mapper.CharacterDetailsPresentationMapper
import com.example.rickandmortyapp.domain.usecase.GetAllCharactersUseCase
import com.example.rickandmortyapp.presentation.model.CharacterUiItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CharactersUiState(
    val isLoading: Boolean = false,
    val charactersList: List<CharacterUiItem>? = null,
    val errorMessage: String? = null
)

sealed class CharacterAction {
    data object FetchAllCharacters : CharacterAction()
}

class CharactersViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val characterDetailsPresentationMapper: CharacterDetailsPresentationMapper
) : ViewModel() {

    private val _charactersUiState = MutableStateFlow(CharactersUiState())
    val charactersUiState: StateFlow<CharactersUiState> = _charactersUiState.asStateFlow()

    fun sendAction(action: CharacterAction): Any {
        return when (action) {
            is CharacterAction.FetchAllCharacters -> fetchAllCharacters()
        }
    }

    private fun fetchAllCharacters() {
        viewModelScope.launch {
            _charactersUiState.update { it.copy(isLoading = true) }
            getAllCharactersUseCase().map { charactersList ->
                _charactersUiState.update {
                    it.copy(
                        isLoading = false,
                        charactersList = characterDetailsPresentationMapper.mapList(
                            charactersList.results
                        )
                    )
                }
            }.catch { error ->
                _charactersUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.message
                    )
                }
            }
        }
    }
}
