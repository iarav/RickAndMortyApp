package com.example.rickandmortyapp.home.di

import com.example.rickandmortyapp.home.data.mapper.CharactersMapper
import com.example.rickandmortyapp.home.domain.usecase.GetAllCharactersUseCase
import com.example.rickandmortyapp.home.presentation.viewmodel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeRickAndMortyModule {
    val dataModule = module {
        factory { CharactersMapper() }
    }

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
