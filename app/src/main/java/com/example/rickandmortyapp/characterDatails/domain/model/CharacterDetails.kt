package com.example.rickandmortyapp.characterDatails.domain.model

data class CharacterDetails(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episodes: List<String>,
    val url: String,
    val created: String
)