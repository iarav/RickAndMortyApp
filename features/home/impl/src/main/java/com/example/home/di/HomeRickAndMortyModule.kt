package com.example.home.di

import com.example.home.domain.usecase.GetAllCharactersUseCase
import com.example.home.presentation.view.CharactersView
import com.example.home.presentation.view.CharactersViewImpl
import com.example.home.presentation.viewmodel.CharactersViewModel
import com.example.home.presentation.viewmodel.CharactersViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeRickAndMortyModule {
    val domainModule = module {
        factory{
            GetAllCharactersUseCase(
                characterRepository = get(),
                dispatcher = get()
            )
        }
    }

    val presentationModule = module {
        viewModel<CharactersViewModel> {
            CharactersViewModelImpl(
                getAllCharactersUseCase = get(),
                characterPresentationMapper = get()
            )
        }

        single<CharactersView> { CharactersViewImpl() }
    }
}
