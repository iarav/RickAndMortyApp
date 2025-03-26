package com.example.common.domain.mapper

import com.example.common.domain.model.CharacterDetails
import com.example.common.domain.model.Location
import org.junit.Before
import org.junit.Test

class CharacterPresentationMapperTest {

    private lateinit var mapper: CharacterPresentationMapper

    @Before
    fun setUp() {
        mapper = CharacterPresentationMapper()
    }

    @Test
    fun `GIVEN character details WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            episodes = listOf(
                "https://rickandmortyapi.com/api/episode/1"
            )
        )

        val result = mapper.map(characterDetails)

        assert(result.id == characterDetails.id)
        assert(result.name == characterDetails.name)
        assert(result.status == "Vivo")
        assert(result.species == "Humano")
        assert(result.type == characterDetails.type)
        assert(result.gender == "Feminino")
        assert(result.image == characterDetails.image)
        assert(result.episodes == listOf("1"))
        assert(result.url == characterDetails.url)
        assert(result.created == characterDetails.created)
    }

    @Test
    fun `GIVEN character details list WHEN map to presentation THEN return correct character ui item list`() {
        val characterDetails = mockCharacterDetails(
            episodes = listOf(
                "https://rickandmortyapi.com/api/episode/1"
            )
        )
        val characterDetailsList = listOf(characterDetails)

        val result = mapper.mapList(characterDetailsList)

        assert(result.size == 1)
        assert(result[0].id == characterDetails.id)
        assert(result[0].name == characterDetails.name)
        assert(result[0].status == "Vivo")
        assert(result[0].species == "Humano")
        assert(result[0].type == characterDetails.type)
        assert(result[0].gender == "Feminino")
        assert(result[0].image == characterDetails.image)
        assert(result[0].episodes == listOf("1"))
        assert(result[0].url == characterDetails.url)
        assert(result[0].created == characterDetails.created)
    }

    @Test
    fun `GIVEN empty character details list WHEN map to presentation THEN return empty character ui item list`() {
        val result = mapper.mapList(emptyList())

        assert(result.isEmpty())
    }

    @Test
    fun `GIVEN character details with dead status WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            status = "Dead"
        )

        val result = mapper.map(characterDetails)

        assert(result.status == "Morto")
    }

    @Test
    fun `GIVEN character details with unknown status WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            status = "Unknown"
        )

        val result = mapper.map(characterDetails)

        assert(result.status == "Desconhecido")
    }

    @Test
    fun `GIVEN character details with humanoid species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Humanoid"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Humanoide")
    }

    @Test
    fun `GIVEN character details with mytholog species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Mytholog"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Mitológico")
    }

    @Test
    fun `GIVEN character details with mythological creature species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Mythological Creature"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Criatura mitológica")
    }

    @Test
    fun `GIVEN character details with animal species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Animal"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Animal")
    }

    @Test
    fun `GIVEN character details with robot species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Robot"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Robô")
    }

    @Test
    fun `GIVEN character details with alien species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Alien"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Alienígena")
    }

    @Test
    fun `GIVEN character details with unknown species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "unknown"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Desconhecido")
    }

    @Test
    fun `GIVEN character details with unpredicted species WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            species = "Another Species that is not expected"
        )

        val result = mapper.map(characterDetails)

        assert(result.species == "Another Species that is not expected")
    }

    @Test
    fun `GIVEN character details with Male gender WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            gender = "Male"
        )

        val result = mapper.map(characterDetails)

        assert(result.gender == "Masculino")
    }

    @Test
    fun `GIVEN character details with genderless gender WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            gender = "Genderless"
        )

        val result = mapper.map(characterDetails)

        assert(result.gender == "Sem gênero")
    }

    @Test
    fun `GIVEN character details with unknown gender WHEN map to presentation THEN return correct character ui item`() {
        val characterDetails = mockCharacterDetails(
            gender = "unknown"
        )

        val result = mapper.map(characterDetails)

        assert(result.gender == "Desconhecido")
    }

    @Test
    fun `GIVEN character details with a list of episodes when map to presentation THEN return correct character ui item only with the episodes numbers`() {
        val characterDetails = mockCharacterDetails(
            episodes = listOf(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2",
                "https://rickandmortyapi.com/api/episode/3",
                "https://rickandmortyapi.com/api/episode/20"
            )
        )

        val result = mapper.map(characterDetails)

        assert(result.episodes == listOf("1", "2", "3", "20"))
    }

    private fun mockCharacterDetails(
        status: String = "Alive",
        species: String = "Human",
        gender: String = "Female",
        episodes: List<String> = emptyList()
    ): CharacterDetails {
        return CharacterDetails(
            id = 1,
            name = "Rick",
            status = status,
            species = species,
            type = "Scientist",
            gender = gender,
            origin = Location("Test", "url"),
            location = Location("Test", "url"),
            image = "image",
            episodes = episodes,
            url = "url",
            created = "created"
        )
    }
}