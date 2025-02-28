package com.example.rickandmortyapp.characterDatails.presentation.view.component

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RickAndMortyTopBarComponent() {
    val context = LocalContext.current
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
                if (context is Activity) {
                    context.finish()
                }
            }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
            }
        }
    )
}