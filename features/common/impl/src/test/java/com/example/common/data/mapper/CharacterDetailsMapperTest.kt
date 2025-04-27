package com.example.common.data.mapper

import com.example.common.data.api.dto.CharacterDataResponse
import com.example.common.data.api.dto.LocationResponse
import org.junit.Before
import org.junit.Test

class CharacterDetailsMapperTest {
    private lateinit var characterDetailsMapper: CharacterDetailsMapper

    @Before
    fun setUp() {
        characterDetailsMapper = CharacterDetailsMapper()
    }

    @Test
    fun `GIVEN characters response WHEN map to domain THEN return correct characters list`() {
        val charactersResponse = mockCharactersResponse()

        val result = characterDetailsMapper.map(charactersResponse)

        assert(result.id == charactersResponse.id)
        assert(result.name == charactersResponse.name)
        assert(result.status == charactersResponse.status)
        assert(result.species == charactersResponse.species)
        assert(result.type == charactersResponse.type)
        assert(result.gender == charactersResponse.gender)
        assert(result.origin.name == charactersResponse.origin.name)
        assert(result.origin.url == charactersResponse.origin.url)
        assert(result.location.name == charactersResponse.location.name)
        assert(result.location.url == charactersResponse.location.url)
        assert(result.image == charactersResponse.image)
        assert(result.episodes == charactersResponse.episode)
        assert(result.url == charactersResponse.url)
        assert(result.created == charactersResponse.created)
    }

    private fun mockCharactersResponse(): CharacterDataResponse {
        return CharacterDataResponse(
            1,
            "Rick",
            "Alive",
            "Human",
            "Scientist",
            gender = "Male",
            origin = LocationResponse("Earth", "url"),
            location = LocationResponse("Earth", "url"),
            image = "image",
            episode = listOf("episode"),
            url = "url",
            created = "created"
        )
    }
}
