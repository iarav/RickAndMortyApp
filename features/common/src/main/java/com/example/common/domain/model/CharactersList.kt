package com.example.common.domain.model

data class CharactersList(
    val info: CharactersPaging?,
    val results: List<CharacterDetails>?
)
