package com.example.home.domain.usecase

import com.example.common.domain.model.CharactersList
import kotlinx.coroutines.flow.Flow

abstract class GetAllCharactersUseCase {
    abstract operator fun invoke() : Flow<CharactersList>
}