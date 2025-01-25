package com.example.rickandmortyapp.data.datasource.api

import com.example.rickandmortyapp.data.datasource.api.dto.CharacterDataResponse
import com.example.rickandmortyapp.data.datasource.api.dto.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("character")
    suspend fun getAllCharacters(): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterDataResponse
}