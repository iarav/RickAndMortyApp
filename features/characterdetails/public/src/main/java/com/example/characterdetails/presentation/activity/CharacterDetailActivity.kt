package com.example.characterdetails.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.characterdetails.presentation.view.CharacterDetailView
import com.example.designsystem.ui.theme.RickAndMortyAppTheme
import org.koin.android.ext.android.inject

const val CHARACTER_ID = "CHARACTER_ID"

class CharacterDetailActivity: ComponentActivity() {

    private val characterDetailView: CharacterDetailView by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val characterId = intent.getIntExtra(CHARACTER_ID, 0)
            RickAndMortyAppTheme {
                characterDetailView.Render(characterId)
            }
        }
    }
}
