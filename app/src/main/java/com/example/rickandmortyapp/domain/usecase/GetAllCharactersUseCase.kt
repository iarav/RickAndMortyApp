package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.model.CharactersList
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke() : Flow<CharactersList> {
        return characterRepository.getAllCharacters()
    }
}