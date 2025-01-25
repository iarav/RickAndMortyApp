package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.model.CharacterDetails
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterByIdUseCase(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(id: Int) : Flow<CharacterDetails> {
        return characterRepository.getCharacterById(id)
    }
}