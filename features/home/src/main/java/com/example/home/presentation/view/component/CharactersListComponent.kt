package com.example.home.presentation.view.component

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.characterdetails.presentation.activity.CHARACTER_ID
import com.example.common.presentation.model.CharacterUiItem
import com.example.characterdetails.presentation.activity.CharacterDetailActivity
import com.example.designsystem.R

@Composable
internal fun CharactersListComponent(
    charactersList: List<CharacterUiItem>
) {
    val context = LocalContext.current
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(charactersList.size) { index ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        val intent = Intent(context, CharacterDetailActivity::class.java).apply {
                            putExtra(CHARACTER_ID, charactersList[index].id)
                        }
                        context.startActivity(intent)
                    }
            ) {
                Text(
                    text = charactersList[index].name,
                    maxLines = 2,
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W600
                )
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = stringResource(R.string.status_title),
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text =
                        charactersList[index].status
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = stringResource(R.string.species_title),
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = charactersList[index].species
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = stringResource(R.string.gender_title),
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = charactersList[index].gender
                    )
                }
                AsyncImage(
                    model = charactersList[index].image,
                    contentDescription = charactersList[index].name,
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
        }
    }
}