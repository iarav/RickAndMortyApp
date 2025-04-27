package com.example.common.data.mapper

import com.example.common.data.api.dto.CharacterDataResponse
import com.example.common.data.api.dto.CharactersPagingResponse
import com.example.common.data.api.dto.CharactersResponse
import com.example.common.data.api.dto.LocationResponse
import org.junit.Before
import org.junit.Test

class CharactersMapperTest {
    private lateinit var charactersMapper: CharactersMapper

    @Before
    fun setUp() {
        charactersMapper = CharactersMapper()
    }

    @Test
    fun `GIVEN characters response WHEN map to domain THEN return correct characters list`() {
        val charactersResponse = mockCharactersResponse()

        val result = charactersMapper.map(charactersResponse)

        assert(result.info?.count == charactersResponse.info.count)
        assert(result.info?.pages == charactersResponse.info.pages)
        assert(result.info?.next == charactersResponse.info.next)
        assert(result.info?.prev == charactersResponse.info.prev)

        assert(result.results?.size == charactersResponse.results.size)
        assert(result.results!![0].id == charactersResponse.results[0].id)
        assert(result.results!![0].name == charactersResponse.results[0].name)
        assert(result.results!![0].status == charactersResponse.results[0].status)
        assert(result.results!![0].species == charactersResponse.results[0].species)
        assert(result.results!![0].type == charactersResponse.results[0].type)
        assert(result.results!![0].gender == charactersResponse.results[0].gender)
        assert(result.results!![0].origin.name == charactersResponse.results[0].origin.name)
        assert(result.results!![0].origin.url == charactersResponse.results[0].origin.url)
        assert(result.results!![0].location.name == charactersResponse.results[0].location.name)
        assert(result.results!![0].location.url == charactersResponse.results[0].location.url)
        assert(result.results!![0].image == charactersResponse.results[0].image)
        assert(result.results!![0].episodes == charactersResponse.results[0].episode)
        assert(result.results!![0].url == charactersResponse.results[0].url)
        assert(result.results!![0].created == charactersResponse.results[0].created)
    }

    private fun mockCharactersResponse(): CharactersResponse {
        return CharactersResponse(
            CharactersPagingResponse(1, 1, "next", "prev"),
            listOf(
                CharacterDataResponse(
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
            )
        )
    }
}
