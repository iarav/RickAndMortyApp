package com.example.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.domain.mapper.CharacterPresentationMapper
import com.example.home.domain.usecase.GetAllCharactersUseCase
import com.example.common.presentation.model.CharacterUiItem
import com.example.designsystem.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CharactersUiState(
    val isLoading: Boolean = false,
    val charactersList: List<CharacterUiItem>? = null,
    val errorMessage: Int? = null
)

sealed class CharacterAction {
    data object FetchAllCharacters : CharacterAction()
}

class CharactersViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val characterPresentationMapper: CharacterPresentationMapper
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
                        charactersList = characterPresentationMapper.mapList(
                            charactersList.results
                        )
                    )
                }
            }.catch {
                _charactersUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = R.string.error_characters_list
                    )
                }
            }.collect()
        }
    }
}
