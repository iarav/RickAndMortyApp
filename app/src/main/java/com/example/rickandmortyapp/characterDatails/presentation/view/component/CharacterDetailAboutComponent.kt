package com.example.rickandmortyapp.characterDatails.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.common.presentation.model.CharacterUiItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CharacterDetailAboutComponent(characterDetails: CharacterUiItem) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.status_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = characterDetails.status
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.species_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(end = 4.dp)
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
                    text = stringResource(R.string.type_title),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(end = 4.dp)
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
                text = stringResource(R.string.gender_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = characterDetails.gender
            )
        }
        Text(
            text = stringResource(R.string.episodes_title),
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        FlowRow(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            characterDetails.episodes.forEach {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 50.dp, minHeight = 50.dp)
                        .background(
                            color = colorResource(R.color.rick_and_morty_dark_sea_green),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(8.dp),
                        color = colorResource(R.color.white)
                    )
                }
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
            episodes = listOf("https://rickandmortyapi.com/api/episode/1"),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )
    )
)
