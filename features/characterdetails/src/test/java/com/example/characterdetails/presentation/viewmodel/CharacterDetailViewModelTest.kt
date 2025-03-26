package com.example.characterdetails.presentation.viewmodel

import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.Location
import com.example.characterdetails.domain.usecase.GetCharacterByIdUseCase
import com.example.common.domain.mapper.CharacterPresentationMapper
import com.example.common.presentation.model.CharacterUiItem
import com.example.designsystem.R
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailViewModelTest {
    private lateinit var characterDetailViewModel: CharacterDetailViewModel
    private val getCharacterByIdUseCase = mockk<GetCharacterByIdUseCase>()
    private val characterPresentationMapper = mockk<CharacterPresentationMapper>()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        characterDetailViewModel =
            CharacterDetailViewModel(
                getCharacterByIdUseCase = getCharacterByIdUseCase,
                characterPresentationMapper = characterPresentationMapper
            )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN fetch character details WHEN called THEN update characterDetailUiState successfully`() = runTest {
        val characterList = mockCharacterDetails()
        val characterUiItem = mockCharacterUiItem()
        
        val id = 1

        coEvery { getCharacterByIdUseCase(any()) } returns flowOf(characterList)
        every { characterPresentationMapper.map(characterList) } returns characterUiItem

        characterDetailViewModel.sendAction(CharacterDetailAction.FetchCharacterDetails(id))

        advanceUntilIdle()

        val expectedState =
            CharacterDetailUiState(
                isLoading = false,
                characterDetails = characterUiItem
            )
        val state = characterDetailViewModel.characterDetailUiState.first()
        assertEquals(expectedState, state)
    }

    @Test
    fun `GIVEN fetch character details WHEN error occurs THEN update characterDetailUiState with error`() = runTest {
        coEvery { getCharacterByIdUseCase(any()) } returns flow {
            throw Exception("Error")
        }
        
        val id = 1

        characterDetailViewModel.sendAction(CharacterDetailAction.FetchCharacterDetails(id))

        advanceUntilIdle()

        val expectedState =
            CharacterDetailUiState(
                isLoading = false,
                errorMessage = R.string.error_character_details
            )
        val state = characterDetailViewModel.characterDetailUiState.first()
        assertEquals(expectedState, state)
    }

    private fun mockCharacterUiItem(): CharacterUiItem {
        return CharacterUiItem(
            id = 1,
            name = "Rick Sanchez",
            status = "Vivo",
            species = "Humano",
            type = "Scientist",
            gender = "Masculino",
            image = "image",
            episodes = listOf("1", "2"),
            url = "url",
            created = "created"
        )
    }

    private fun mockCharacterDetails(): CharacterDetails {
        return CharacterDetails(
            id = 1,
            name = "Rick",
            status = "Vivo",
            species = "Humano",
            type = "Scientist",
            gender = "Masculino",
            origin = Location(
                name = "Earth",
                url = "url"
            ),
            location = Location(
                name = "Earth",
                url = "url"
            ),
            image = "image",
            episodes = listOf("1", "2"),
            url = "url",
            created = "created"
        )
    }
}