package com.example.rickandmortyapp.presentation.view.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.presentation.view.component.CharacterNameComponent
import com.example.rickandmortyapp.presentation.view.component.CharacterImageComponent

@OptIn(ExperimentalMaterial3Api::class)
class CharacterDetailView {

    val characterName = "Rick"
    val characterImage = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    val characterStatus = "Alive"
    val characterSpecies = "Human"

    @Composable
    fun CharacterDetails() {
        Scaffold(
            topBar = {
                RickAndMortyTopBar()
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                CharacterDetailsContent()
            }
        }
    }

    @Composable
    private fun CharacterDetailsContent() {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CharacterImageComponent(
                    characterImage = characterImage,
                    characterName = characterName
                )
                CharacterNameComponent(characterName)
//                CharacterDetailAbout(characterStatus, characterSpecies)
            }
        }
    }

    @Composable
    private fun RickAndMortyTopBar() {
        TopAppBar(
            colors = TopAppBarColors(
                containerColor = colorResource(R.color.rick_and_morty_sea_green),
                titleContentColor = colorResource(R.color.black),
                scrolledContainerColor = colorResource(R.color.rick_and_morty_sea_green),
                navigationIconContentColor = colorResource(R.color.black),
                actionIconContentColor = colorResource(R.color.black)
            ),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Rick and Morty",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(48.dp))
                }
            },
            navigationIcon = {
                IconButton(onClick = {
                    // TODO - Implement back navigation
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            }
        )
    }

    @Preview
    @Composable
    private fun CharacterDetailsPreview() {
        CharacterDetails()
    }
}