package com.example.characterdetails.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.characterdetails.presentation.view.component.CharacterDetailAboutComponent
import com.example.characterdetails.presentation.view.component.CharacterNameComponent
import com.example.characterdetails.presentation.view.component.CharacterImageComponent
import com.example.characterdetails.presentation.view.component.RickAndMortyTopBarComponent
import com.example.characterdetails.presentation.viewmodel.CharacterDetailAction
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModel
import com.example.common.presentation.model.CharacterUiItem
import com.example.common.presentation.view.component.ErrorComponent
import com.example.common.presentation.view.component.LoadingComponent

class CharacterDetailViewImpl : CharacterDetailView() {

    @Composable
    override fun CharacterDetails(
        characterId: Int,
        onBackButtonPressed: () -> Unit,
        viewModel: CharacterDetailViewModel
    ) {
        val uiState by viewModel.characterDetailUiState.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.sendAction(CharacterDetailAction.FetchCharacterDetails(characterId))
        }

        Scaffold(
            topBar = {
                RickAndMortyTopBarComponent(
                    onBackButtonPressed
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                if (uiState.isLoading) {
                    LoadingComponent(
                        modifier = Modifier.padding(top = 100.dp)
                    )
                } else if (uiState.errorMessage != null) {
                    ErrorComponent(
                        stringResource(
                            uiState.errorMessage!!
                        )
                    )
                } else {
                    uiState.characterDetails?.let { CharacterDetailsContent(it) }
                }
            }
        }
    }

    @Composable
    private fun CharacterDetailsContent(
        characterDetails: CharacterUiItem
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    CharacterImageComponent(
                        characterImage = characterDetails.image,
                        characterName = characterDetails.name
                    )
                }
                item {
                    CharacterNameComponent(characterDetails.name)
                }
                item {
                    CharacterDetailAboutComponent(characterDetails)
                }
            }
        }
    }

    @Preview
    @Composable
    private fun CharacterDetailsPreview() {
        CharacterDetailsContent(
            CharacterUiItem(
                id = 0,
                name = "Rick Sanchez",
                status = "Alive",
                species = "Human",
                type = "",
                gender = "Male",
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                episodes = emptyList(),
                url = "",
                created = ""
            )
        )
    }
}
