package com.example.rickandmortyapp.home.domain.model

import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails

data class CharactersList(
    val info: CharactersPaging?,
    val results: List<CharacterDetails>?
)
