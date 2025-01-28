package com.example.rickandmortyapp.presentation.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickandmortyapp.presentation.view.component.characters.CHARACTER_ID
import com.example.rickandmortyapp.presentation.view.view.CharacterDetailView
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme

class CharacterDetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val characterId = intent.getIntExtra(CHARACTER_ID, 0)
            RickAndMortyAppTheme {
                CharacterDetailView().CharacterDetails(characterId)
            }
        }
    }
}