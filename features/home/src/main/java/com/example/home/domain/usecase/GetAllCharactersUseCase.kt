package com.example.home.domain.usecase

import com.example.common.domain.model.CharactersList
import com.example.common.domain.repository.CharacterRepository
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