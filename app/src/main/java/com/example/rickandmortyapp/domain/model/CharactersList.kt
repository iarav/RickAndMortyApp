package com.example.rickandmortyapp.domain.model

data class CharactersList(
    val info: CharactersPaging?,
    val results: List<CharacterDetails>?
)
