package com.example.rickandmortyapp.characterDatails.data.mapper

import com.example.rickandmortyapp.common.data.api.dto.CharacterDataResponse
import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails
import com.example.rickandmortyapp.characterDatails.domain.model.Location

class CharacterDetailsMapper {
    fun map(source: CharacterDataResponse) : CharacterDetails {
        val mappedSource = source.let {
            CharacterDetails(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                type = it.type,
                gender = it.gender,
                origin = Location(it.origin.name, it.origin.url),
                location = Location(it.location.name, it.location.url),
                image = it.image,
                episodes = it.episode,
                url = it.url,
                created = it.created
            )
        }
        return mappedSource
    }
}