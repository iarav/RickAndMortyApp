package com.example.common.data.repository

import com.example.common.data.api.CharacterApi
import com.example.common.data.api.dto.CharacterDataResponse
import com.example.common.data.api.dto.CharactersPagingResponse
import com.example.common.data.api.dto.CharactersResponse
import com.example.common.data.api.dto.LocationResponse
import com.example.common.data.mapper.CharacterDetailsMapper
import com.example.common.data.mapper.CharactersMapper
import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.CharactersList
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterRepositoryImplTest {
    private lateinit var characterRepositoryImpl: CharacterRepositoryImpl
    private val characterApi = mockk<CharacterApi>()
    private val charactersMapper = mockk<CharactersMapper>()
    private val characterDetailsMapper = mockk<CharacterDetailsMapper>()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        characterRepositoryImpl = CharacterRepositoryImpl(
            characterApi = characterApi,
            charactersMapper = charactersMapper,
            characterDetailsMapper = characterDetailsMapper
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN get all characters WHEN called THEN return characters list`() = runTest {
        val apiResponse = mockCharactersResponse()
        val mappedResponse = mockk<CharactersList>()

        coEvery { characterApi.getAllCharacters() } returns apiResponse
        every { charactersMapper.map(apiResponse) } returns mappedResponse

        val result = characterRepositoryImpl.getAllCharacters().first()

        assert(result == mappedResponse)

        coVerify(exactly = 1) { characterApi.getAllCharacters() }
        coVerify(exactly = 1) { charactersMapper.map(apiResponse) }
        coVerify(exactly = 0) { characterDetailsMapper.map(any()) }
    }

    @Test(expected = Exception::class)
    fun `GIVEN get all characters WHEN API fails THEN throw exception`() = runTest {
        coEvery { characterApi.getAllCharacters() } throws Exception("Network error")

        characterRepositoryImpl.getAllCharacters().first()

        coVerify(exactly = 1) { characterApi.getAllCharacters() }
        coVerify(exactly = 0) { charactersMapper.map(any()) }
    }

    @Test
    fun `GIVEN get character by ID WHEN called THEN return character details`() = runTest {
        val characterId = 1
        val apiResponse = mockCharacterDetailsResponse()
        val mappedResponse = mockk<CharacterDetails>()

        coEvery { characterApi.getCharacterById(characterId) } returns apiResponse
        every { characterDetailsMapper.map(apiResponse) } returns mappedResponse

        val result = characterRepositoryImpl.getCharacterById(characterId).first()

        assert(result == mappedResponse)

        coVerify(exactly = 1) { characterApi.getCharacterById(characterId) }
        coVerify(exactly = 1) { characterDetailsMapper.map(apiResponse) }
        coVerify(exactly = 0) { charactersMapper.map(any()) }
    }

    @Test(expected = Exception::class)
    fun `GIVEN get character by ID WHEN API fails THEN throw exception`() = runTest {
        val characterId = 1

        coEvery { characterApi.getCharacterById(characterId) } throws Exception("API error")

        characterRepositoryImpl.getCharacterById(characterId).first()

        coVerify(exactly = 1) { characterApi.getCharacterById(characterId) }
        coVerify(exactly = 0) { characterDetailsMapper.map(any()) }
    }

    private fun mockCharactersResponse(): CharactersResponse {
        return CharactersResponse(
            info = CharactersPagingResponse(
                count = 1,
                pages = 1,
                next = "next",
                prev = "prev"
            ),
            results = listOf(
                mockCharacterDetailsResponse()
            )
        )
    }

    private fun mockCharacterDetailsResponse(): CharacterDataResponse {
        return CharacterDataResponse(
            id = 1,
            name = "Rick",
            status = "Alive",
            species = "Human",
            type = "Scientist",
            gender = "Male",
            origin = LocationResponse(name = "Earth", url = "url"),
            location = LocationResponse(
                name = "Earth",
                url = "url"
            ),
            image = "image",
            episode = listOf("episode"),
            url = "url",
            created = "created"
        )
    }
}
