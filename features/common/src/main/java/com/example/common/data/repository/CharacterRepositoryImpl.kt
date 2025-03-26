package com.example.common.data.repository

import android.util.Log
import com.example.common.data.api.CharacterApi
import com.example.common.data.mapper.CharacterDetailsMapper
import com.example.common.data.mapper.CharactersMapper
import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.CharactersList
import com.example.common.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val characterApi: CharacterApi,
    private val charactersMapper: CharactersMapper,
    private val characterDetailsMapper: CharacterDetailsMapper
) : CharacterRepository {
    override fun getAllCharacters(): Flow<CharactersList> = flow {
        val response = characterApi.getAllCharacters()
        val mappedResponse = charactersMapper.map(response)
        emit(mappedResponse)
    }.catch {
        Log.e("HttpRequestException", "GetAllCharacters - Error - message: ${it.message}.")
        throw Exception(it.message)
    }

    override fun getCharacterById(id: Int): Flow<CharacterDetails> = flow {
        val response = characterApi.getCharacterById(id)
        val mappedResponse = characterDetailsMapper.map(response)
        emit(mappedResponse)
    }.catch {
        Log.e("HttpRequestException", "GetCharacterById - Error - message: ${it.message}.")
        throw Exception(it.message)
    }
}