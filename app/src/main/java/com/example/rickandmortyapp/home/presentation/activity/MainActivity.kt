package com.example.rickandmortyapp.home.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.home.presentation.view.CharactersView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {
                CharactersView().CharactersListView()
            }
        }
    }
}