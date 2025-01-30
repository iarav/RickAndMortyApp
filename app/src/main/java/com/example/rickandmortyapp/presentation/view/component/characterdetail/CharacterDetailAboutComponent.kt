package com.example.rickandmortyapp.presentation.view.component.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.presentation.model.CharacterUiItem

@Composable
internal fun CharacterDetailAboutComponent(characterDetails: CharacterUiItem) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.status_title)
            )
            Text(
                text = characterDetails.status
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.species_title)
            )
            Text(
                text = characterDetails.species
            )
        }
        if (characterDetails.type.isNotEmpty()) {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(R.string.type_title)
                )
                Text(
                    text = characterDetails.type
                )
            }
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.gender_title)
            )
            Text(
                text = characterDetails.gender
            )
        }
        Column {
            Text(
                text = stringResource(R.string.episodes_title)
            )
            characterDetails.episode.forEach {
                Text(
                    text = it
                )
            }
        }
    }
}

@Composable
@Preview
internal fun CharacterDetailAboutComponentPreview(
    @PreviewParameter(CharacterDetailsPreviewProvider::class) characterDetails: CharacterUiItem
) {
    CharacterDetailAboutComponent(characterDetails = characterDetails)
}

class CharacterDetailsPreviewProvider : CollectionPreviewParameterProvider<CharacterUiItem>(
    listOf(
        CharacterUiItem(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "Tipo",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf("https://rickandmortyapi.com/api/episode/1"),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )
    )
)
