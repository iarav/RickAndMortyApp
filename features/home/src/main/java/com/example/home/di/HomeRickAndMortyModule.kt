package com.example.home.di

import com.example.home.domain.usecase.GetAllCharactersUseCase
import com.example.home.presentation.viewmodel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeRickAndMortyModule {
    val domainModule = module {
        factory { GetAllCharactersUseCase(characterRepository = get(), dispatcher = get()) }
    }

    val presentationModule = module {
        viewModel {
            CharactersViewModel(
                getAllCharactersUseCase = get(),
                characterPresentationMapper = get()
            )
        }
    }
}
