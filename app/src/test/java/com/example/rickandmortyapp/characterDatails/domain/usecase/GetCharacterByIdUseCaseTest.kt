package com.example.rickandmortyapp.characterDatails.domain.usecase

import android.util.Log
import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails
import com.example.rickandmortyapp.common.domain.repository.CharacterRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCharacterByIdUseCaseTest {
    private lateinit var getCharacterByIdUseCase: GetCharacterByIdUseCase
    private val characterRepository = mockk<CharacterRepository>()
    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        getCharacterByIdUseCase = GetCharacterByIdUseCase(
            characterRepository = characterRepository,
            dispatcher = dispatcher
        )
    }

    @Test
    fun `GIVEN get character by id WHEN called THEN call repository and return character details`() = runTest {
        val expectedCharactersList = mockk<CharacterDetails>()
        val id = 1

        coEvery { characterRepository.getCharacterById(id) } returns flowOf(expectedCharactersList)

        val result = getCharacterByIdUseCase(id).first()

        coVerify { characterRepository.getCharacterById(id) }
        assert(result == expectedCharactersList)
    }

    @Test
    fun `GIVEN get character by id WHEN repository throws exception THEN throw exception`() = runTest {
        val id = 1
        val repositoryException = Exception("Error")
        val expectedException = Exception("Erro ao buscar detalhes do personagem: ${repositoryException.message}")

        mockkStatic(Log::class)
        coEvery { Log.e(any(), any()) } returns 0

        coEvery { characterRepository.getCharacterById(id) } throws repositoryException

        val result = runCatching {
            getCharacterByIdUseCase(id).first()
        }

        assertTrue(result.exceptionOrNull()?.message == expectedException.message)
        assert(result.exceptionOrNull() is Exception)
    }

    @Test
    fun `GIVEN get character by id WHEN called with invalid id THEN throw exception`() = runTest {
        val id = 0

        mockkStatic(Log::class)
        coEvery { Log.e(any(), any()) } returns 0

        val result = runCatching {
            getCharacterByIdUseCase(id).first()
        }

        assertTrue(result.exceptionOrNull() is IllegalArgumentException)
        assertTrue(result.exceptionOrNull()?.message == "Invalid character id")
    }
}