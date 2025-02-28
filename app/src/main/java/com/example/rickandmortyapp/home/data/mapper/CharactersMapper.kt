package com.example.rickandmortyapp.home.data.mapper

import com.example.rickandmortyapp.common.data.api.dto.CharactersResponse
import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails
import com.example.rickandmortyapp.home.domain.model.CharactersList
import com.example.rickandmortyapp.home.domain.model.CharactersPaging
import com.example.rickandmortyapp.characterDatails.domain.model.Location

class CharactersMapper {
    fun map(source: CharactersResponse) : CharactersList {
        return source.let { charactersResponse ->
            val charactersPaging = charactersResponse.info.let {
                CharactersPaging(
                    it.count,
                    it.pages,
                    it.next,
                    it.prev
                )
            }
            val characterDetailsList = charactersResponse.results.map {
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

             CharactersList(
                charactersPaging,
                characterDetailsList
            )
        }
    }
}