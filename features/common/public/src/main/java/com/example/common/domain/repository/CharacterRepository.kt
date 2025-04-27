package com.example.common.domain.repository

import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.CharactersList
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<CharactersList>
    fun getCharacterById(id: Int): Flow<CharacterDetails>
}
