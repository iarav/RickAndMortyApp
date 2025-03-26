package com.example.common.data.api

import com.example.common.data.api.dto.CharacterDataResponse
import com.example.common.data.api.dto.CharactersResponse
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