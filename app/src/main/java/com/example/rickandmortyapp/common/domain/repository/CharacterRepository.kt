package com.example.rickandmortyapp.common.domain.repository

import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails
import com.example.rickandmortyapp.home.domain.model.CharactersList
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<CharactersList>
    fun getCharacterById(id: Int): Flow<CharacterDetails>
}