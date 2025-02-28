package com.example.rickandmortyapp.characterDatails.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickandmortyapp.home.presentation.view.component.CHARACTER_ID
import com.example.rickandmortyapp.characterDatails.presentation.view.CharacterDetailView
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