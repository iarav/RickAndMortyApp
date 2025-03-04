package com.example.rickandmortyapp.characterDatails.domain.usecase

import android.util.Log
import com.example.rickandmortyapp.characterDatails.domain.model.CharacterDetails
import com.example.rickandmortyapp.common.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCharacterByIdUseCase(
    private val characterRepository: CharacterRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<CharacterDetails> {
        return flow {
            if (id == 0) {
                Log.e("Exception", "Invalid character id")
                throw IllegalArgumentException("Invalid character id")
            }
            emitAll(characterRepository.getCharacterById(id))
        }
        .catch { error ->
            if (error is IllegalArgumentException) throw error
            Log.e("Exception", "Erro ao buscar detalhes do personagem: ${error.message}")
            throw Exception("Erro ao buscar detalhes do personagem: ${error.message}")
        }
        .flowOn(dispatcher)
    }
}