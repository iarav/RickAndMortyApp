package com.example.rickandmortyapp.characterDatails.di

import com.example.rickandmortyapp.characterDatails.data.mapper.CharacterDetailsMapper
import com.example.rickandmortyapp.characterDatails.domain.usecase.GetCharacterByIdUseCase
import com.example.rickandmortyapp.characterDatails.presentation.viewmodel.CharacterDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CharacterDetaisRickAndMortyModule {
    val dataModule = module {
        factory { CharacterDetailsMapper() }
    }

    val domainModule = module {
        factory { GetCharacterByIdUseCase(characterRepository = get(), dispatcher = get()) }
    }

    val presentationModule = module {
        viewModel {
            CharacterDetailViewModel(
                getCharacterByIdUseCase = get(),
                characterPresentationMapper = get()
            )
        }
    }
}
