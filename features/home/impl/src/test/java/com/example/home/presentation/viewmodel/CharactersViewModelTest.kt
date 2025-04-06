package com.example.home.presentation.viewmodel
import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.Location
import com.example.common.domain.mapper.CharacterPresentationMapper
import com.example.common.presentation.model.CharacterUiItem
import com.example.common.domain.model.CharactersList
import com.example.common.domain.model.CharactersPaging
import com.example.designsystem.R
import com.example.home.domain.usecase.GetAllCharactersUseCase
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
class CharactersViewModelTest {
    private lateinit var charactersViewModel: CharactersViewModel
    private val getAllCharactersUseCase = mockk<GetAllCharactersUseCase>()
    private val characterPresentationMapper = mockk<CharacterPresentationMapper>()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        charactersViewModel = CharactersViewModelImpl(
            getAllCharactersUseCase = getAllCharactersUseCase,
            characterPresentationMapper = characterPresentationMapper
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN fetch all characters WHEN called THEN update charactersUiState successfully`() = runTest {
        val characterList = mockCharactersList()
        val characterUiItems = listOf(mockCharacterUiItem())

        coEvery { getAllCharactersUseCase() } returns flowOf(characterList)
        every { characterPresentationMapper.mapList(characterList.results) } returns characterUiItems

        charactersViewModel.sendAction(CharacterAction.FetchAllCharacters)

        advanceUntilIdle()

        val expectedState = CharactersUiState(
            isLoading = false,
            charactersList = characterUiItems
        )
        val state = charactersViewModel.charactersUiState.first()
        assertEquals(expectedState, state)
    }

    @Test
    fun `GIVEN fetch all characters WHEN error occurs THEN update charactersUiState with error`() = runTest {
        coEvery { getAllCharactersUseCase() } returns flow {
            throw Exception("Error")
        }

        charactersViewModel.sendAction(CharacterAction.FetchAllCharacters)

        advanceUntilIdle()

        val expectedState = CharactersUiState(
            isLoading = false,
            errorMessage = R.string.error_characters_list
        )
        val state = charactersViewModel.charactersUiState.first()
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

    private fun mockCharactersList(): CharactersList {
        return CharactersList(
            info = CharactersPaging(
                count = 1,
                pages = 1,
                next = "next",
                prev = "prev"
            ),
            results = listOf(
                mockCharacterDetails()
            )
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
