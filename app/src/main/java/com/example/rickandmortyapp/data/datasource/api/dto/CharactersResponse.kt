package com.example.rickandmortyapp.data.datasource.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharactersResponse (
    @SerializedName("info") val info: CharactersPagingResponse,
    @SerializedName("results") val results: List<CharacterDataResponse>
): Serializable

data class CharactersPagingResponse (
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
) : Serializable
