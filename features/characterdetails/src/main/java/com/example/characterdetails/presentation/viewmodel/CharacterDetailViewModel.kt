package com.example.characterdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterdetails.domain.usecase.GetCharacterByIdUseCase
import com.example.common.domain.mapper.CharacterPresentationMapper
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

data class CharacterDetailUiState(
    val isLoading: Boolean = false,
    val characterDetails: CharacterUiItem? = null,
    val errorMessage: Int? = null
)

sealed class CharacterDetailAction {
    data class FetchCharacterDetails(val characterId: Int) : CharacterDetailAction()
}

class CharacterDetailViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val characterPresentationMapper: CharacterPresentationMapper
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
            getCharacterByIdUseCase(characterId).map { characterDetails ->
                _characterDetailUiState.update {
                    it.copy(
                        isLoading = false,
                        characterDetails = characterPresentationMapper.map(
                            characterDetails
                        )
                    )
                }
            }.catch {
                _characterDetailUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = R.string.error_character_details
                    )
                }
            }.collect()
        }
    }
}
