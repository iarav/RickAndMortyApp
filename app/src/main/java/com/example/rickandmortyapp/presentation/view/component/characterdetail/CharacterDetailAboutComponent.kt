package com.example.rickandmortyapp.presentation.view.component.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.example.rickandmortyapp.presentation.model.CharacterUiItem

@Composable
internal fun CharacterDetailAboutComponent(characterDetails: CharacterUiItem) {
    Column {
        Row {
            Text(text = "Status:")
            Text(text = characterDetails.status)
        }
        Row {
            Text(text = "Species:")
            Text(text = characterDetails.species)
        }
        Row {
            Text(text = "Type:")
            Text(text = characterDetails.type)
        }
        Row {
            Text(text = "Gender:")
            Text(text = characterDetails.gender)
        }
        Column {
            Text(text = "Episodes:")
            characterDetails.episode.forEach {
                Text(text = it)
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
            type = "",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf("https://rickandmortyapi.com/api/episode/1"),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )
    )
)
