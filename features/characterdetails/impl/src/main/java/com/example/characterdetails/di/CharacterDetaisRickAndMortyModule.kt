package com.example.characterdetails.di

import com.example.characterdetails.domain.usecase.GetCharacterByIdUseCase
import com.example.characterdetails.presentation.view.CharacterDetailView
import com.example.characterdetails.presentation.view.CharacterDetailViewImpl
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModel
import com.example.characterdetails.presentation.viewmodel.CharacterDetailViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CharacterDetaisRickAndMortyModule {
    val domainModule = module {
        factory { GetCharacterByIdUseCase(characterRepository = get(), dispatcher = get()) }
    }

    val presentationModule = module {
        viewModel<CharacterDetailViewModel> {
            CharacterDetailViewModelImpl(
                getCharacterByIdUseCase = get(),
                characterPresentationMapper = get()
            )
        }

        single<CharacterDetailView> { CharacterDetailViewImpl() }
    }
}
