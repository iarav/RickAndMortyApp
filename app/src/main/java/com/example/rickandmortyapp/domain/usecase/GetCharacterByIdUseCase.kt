package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.model.CharacterDetails
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetCharacterByIdUseCase(
    private val characterRepository: CharacterRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<CharacterDetails> {
        return if (id <= 0) {
            characterRepository.getCharacterById(id).flowOn(dispatcher)
        } else {
            throw IllegalArgumentException("Invalid character id")
        }
    }
}