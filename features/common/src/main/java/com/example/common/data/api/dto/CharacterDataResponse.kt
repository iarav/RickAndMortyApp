package com.example.common.data.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterDataResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: LocationResponse,
    @SerializedName("location") val location: LocationResponse,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) : Serializable

data class LocationResponse (
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) : Serializable
