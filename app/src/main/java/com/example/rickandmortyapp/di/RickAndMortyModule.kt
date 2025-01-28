package com.example.rickandmortyapp.di

import com.example.rickandmortyapp.data.datasource.api.CharacterApi
import com.example.rickandmortyapp.data.mapper.CharacterDataMapper
import com.example.rickandmortyapp.data.mapper.CharactersMapper
import com.example.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.example.rickandmortyapp.domain.mapper.CharacterDetailsPresentationMapper
import com.example.rickandmortyapp.domain.repository.CharacterRepository
import com.example.rickandmortyapp.domain.usecase.GetAllCharactersUseCase
import com.example.rickandmortyapp.domain.usecase.GetCharacterByIdUseCase
import com.example.rickandmortyapp.presentation.view.viewmodel.CharacterDetailViewModel
import com.example.rickandmortyapp.presentation.view.viewmodel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickAndMortyModule {
    val dataModule = module {
        factory { CharactersMapper() }
        factory { CharacterDataMapper() }
        factory <CharacterRepository> {
            CharacterRepositoryImpl(
                characterApi = get(),
                charactersMapper = get(),
                characterDataMapper = get()
            )
        }
    }

    val domainModule = module {
        factory { GetAllCharactersUseCase(characterRepository = get()) }
        factory { GetCharacterByIdUseCase(characterRepository = get()) }
        factory { CharacterDetailsPresentationMapper() }
    }

    val presentationModule = module {
        viewModel {
            CharactersViewModel(
                getAllCharactersUseCase = get(),
                characterDetailsPresentationMapper = get()
            )
        }
        viewModel {
            CharacterDetailViewModel(
                getCharacterByIdUseCase = get(),
                characterDetailsPresentationMapper = get()
            )
        }
    }

    val networkModule = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<CharacterApi> {
            get<Retrofit>().create(CharacterApi::class.java)
        }
    }
}
