package com.example.characterdetails.presentation.view.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
internal fun CharacterImageComponent(characterImage: String, characterName: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = characterImage,
            contentDescription = characterName,
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .align(Alignment.Center)
                .padding(16.dp)
        )
    }
}