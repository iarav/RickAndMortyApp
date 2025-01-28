package com.example.rickandmortyapp.presentation.view.component.characterdetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
internal fun CharacterNameComponent(characterName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = characterName,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}