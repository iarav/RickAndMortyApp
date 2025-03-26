package com.example.home.domain.usecase

import com.example.common.domain.repository.CharacterRepository
import com.example.common.domain.model.CharactersList
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllCharactersUseCaseTest {
    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase
    private val characterRepository = mockk<CharacterRepository>()
    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        getAllCharactersUseCase = GetAllCharactersUseCase(
            characterRepository = characterRepository,
            dispatcher = dispatcher
        )
    }

    @Test
    fun `GIVEN get all characters WHEN called THEN call repository and return characters list`() = runTest {
        val expectedCharactersList = mockk<CharactersList>()

        coEvery { characterRepository.getAllCharacters() } returns flowOf(expectedCharactersList)

        val result = getAllCharactersUseCase().first()

        coVerify { characterRepository.getAllCharacters() }
        assert(result == expectedCharactersList)
    }
}