package com.example.rickandmortyapp.home.domain.model

data class CharactersPaging(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
