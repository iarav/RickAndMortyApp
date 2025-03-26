package com.example.characterdetails.di

import com.example.characterdetails.domain.usecase.GetCharacterByIdUseCase
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CharacterDetaisRickAndMortyModule {
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
