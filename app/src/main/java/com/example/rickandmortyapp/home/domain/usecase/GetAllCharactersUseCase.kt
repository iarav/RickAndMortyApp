package com.example.rickandmortyapp.home.domain.usecase

import com.example.rickandmortyapp.home.domain.model.CharactersList
import com.example.rickandmortyapp.common.domain.repository.CharacterRepository
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