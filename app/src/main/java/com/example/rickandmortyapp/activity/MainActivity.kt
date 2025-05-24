package com.example.rickandmortyapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.characterdetails.presentation.view.CharacterDetailView
import com.example.designsystem.ui.theme.RickAndMortyAppTheme
import com.example.home.presentation.view.CharactersView
import com.example.rickandmortyapp.navigation.RickAndMortyNavHost
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val charactersView: CharactersView by inject()
    private val characterDetailView: CharacterDetailView by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {
                RickAndMortyNavHost(
                    charactersView = charactersView,
                    characterDetailView = characterDetailView,
                )
            }
        }
    }
}
