package com.example.home.domain.usecase

import com.example.common.domain.model.CharactersList
import com.example.common.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllCharactersUseCaseImpl(
    private val characterRepository: CharacterRepository,
    private val dispatcher: CoroutineDispatcher
) : GetAllCharactersUseCase() {
    override operator fun invoke() : Flow<CharactersList> {
        return characterRepository.getAllCharacters().flowOn(dispatcher)
    }
}