package com.example.rickandmortyapp.presentation.view.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.presentation.model.CharacterUiItem
import com.example.rickandmortyapp.presentation.view.component.CharactersListComponent
import com.example.rickandmortyapp.presentation.view.viewmodel.CharacterAction
import com.example.rickandmortyapp.presentation.view.viewmodel.CharactersViewModel
import org.koin.androidx.compose.koinViewModel

class CharactersView() {
    @Composable
    fun CharactersListView(viewModel: CharactersViewModel = koinViewModel()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rick_and_morty),
                contentDescription = "rick and morty",
                modifier = Modifier
                    .width(350.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Characters(viewModel)
        }
    }

    @Composable
    private fun Characters(
        viewModel: CharactersViewModel
    ) {
        val uiState by viewModel.charactersUiState.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.sendAction(CharacterAction.FetchAllCharacters)
        }

        if (uiState.isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    CircularProgressIndicator()
                }
            }
        } else if (uiState.errorMessage != null) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError,
                        disabledContentColor = MaterialTheme.colorScheme.onError,
                        disabledContainerColor = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = uiState.errorMessage!!,
                        modifier = Modifier.padding(vertical = 24.dp, horizontal = 50.dp)
                    )
                }
            }
        } else {
            uiState.charactersList?.let { CharactersListComponent(it) }
        }
    }

    @Preview
    @Composable
    private fun PreviewCharacterList() {
        CharactersListComponent(
            charactersList = getPreviewCharacters()
        )
    }

    private fun getPreviewCharacters(): List<CharacterUiItem> {
        return listOf(
            CharacterUiItem(
                id = 1,
                name = "Rick",
                status = "Alive",
                species = "Human",
                type = "",
                gender = "Female",
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                episode = emptyList(),
                url = "",
                created = ""
            )
        )
    }
}