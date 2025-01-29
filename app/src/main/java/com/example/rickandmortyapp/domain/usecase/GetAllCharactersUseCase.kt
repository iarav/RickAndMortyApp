package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.model.CharactersList
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke() : Flow<CharactersList> {
        return characterRepository.getAllCharacters().flowOn(dispatcher)
    }
}