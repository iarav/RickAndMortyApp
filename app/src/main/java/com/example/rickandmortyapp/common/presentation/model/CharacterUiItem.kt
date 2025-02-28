package com.example.rickandmortyapp.common.presentation.model

data class CharacterUiItem (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episodes: List<String>,
    val url: String,
    val created: String
)
