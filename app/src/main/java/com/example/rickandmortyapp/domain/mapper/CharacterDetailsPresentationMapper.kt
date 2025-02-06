package com.example.rickandmortyapp.domain.mapper

import com.example.rickandmortyapp.domain.model.CharacterDetails
import com.example.rickandmortyapp.presentation.model.CharacterUiItem

class CharacterDetailsPresentationMapper {
    fun map(source: CharacterDetails): CharacterUiItem {
        return source.let {
            CharacterUiItem(
                id = it.id,
                name = it.name,
                status = getPortugueseCharacterStatus(it.status),
                species = getPortugueseCharacterSpecies(it.species),
                type = it.type,
                gender = getPortugueseCharacterGender(it.gender),
                image = it.image,
                episodes = getFormattedEpisodes(it.episodes),
                url = it.url,
                created = it.created
            )
        }
    }

    fun mapList(sourceList: List<CharacterDetails>?): List<CharacterUiItem> {
        return sourceList?.map { map(it) } ?: emptyList()
    }

    private fun getPortugueseCharacterStatus(status: String): String {
        return when (status) {
            "Alive" -> "Vivo"
            "Dead" -> "Morto"
            else -> "Desconhecido"
        }
    }

    private fun getPortugueseCharacterSpecies(species: String): String {
        return when (species) {
            "Human" -> "Humano"
            "Humanoid" -> "Humanoide"
            "Mytholog" -> "Mitológico"
            "Mythological Creature" -> "Criatura mitológica"
            "Animal" -> "Animal"
            "Robot" -> "Robô"
            "Alien" -> "Alienígena"
            "unknown" -> "Desconhecido"
            else -> species
        }
    }

    private fun getPortugueseCharacterGender(gender: String): String {
        return when (gender) {
            "Male" -> "Masculino"
            "Female" -> "Feminino"
            "Genderless" -> "Sem gênero"
            else -> "Desconhecido"
        }
    }

    private fun getFormattedEpisodes(episodes: List<String>): List<String> {
        return episodes.map {
            it.substringAfterLast("/")
        }
    }
}