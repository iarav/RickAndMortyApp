package com.example.rickandmortyapp.data.repository

import android.util.Log
import com.example.rickandmortyapp.data.datasource.api.CharacterApi
import com.example.rickandmortyapp.data.mapper.CharacterDataMapper
import com.example.rickandmortyapp.data.mapper.CharactersMapper
import com.example.rickandmortyapp.domain.model.CharacterDetails
import com.example.rickandmortyapp.domain.model.CharactersList
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val characterApi: CharacterApi,
    private val charactersMapper: CharactersMapper,
    private val characterDataMapper: CharacterDataMapper
) : CharacterRepository {
    override fun getAllCharacters(): Flow<CharactersList> = flow {
        val response = characterApi.getAllCharacters()
        val mappedResponse = charactersMapper.map(response)
        emit(mappedResponse)
    }.catch {
        Log.e("HttpRequest", "GetAllCharacters - Error - message: ${it.message}.")
        throw Exception("Erro ao buscar personagens :(")
    }

    override fun getCharacterById(id: Int): Flow<CharacterDetails> = flow {
        val response = characterApi.getCharacterById(id)
        val mappedResponse = characterDataMapper.map(response)
        emit(mappedResponse)
    }.catch {
        Log.e("HttpRequest", "GetCharacterById - Error - message: ${it.message}.")
        throw Exception("Erro ao buscar personagem")
    }
}