package com.example.rickandmortyapp.common.di

import com.example.rickandmortyapp.common.data.api.CharacterApi
import com.example.rickandmortyapp.common.data.repository.CharacterRepositoryImpl
import com.example.rickandmortyapp.common.domain.mapper.CharacterPresentationMapper
import com.example.rickandmortyapp.common.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonRickAndMortyModule {
    val dataModule = module {
        factory <CharacterRepository> {
            CharacterRepositoryImpl(
                characterApi = get(),
                charactersMapper = get(),
                characterDetailsMapper = get()
            )
        }
    }

    val domainModule = module {
        factory { CharacterPresentationMapper() }
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

    val coroutineModule = module {
        single<CoroutineDispatcher> { Dispatchers.IO }
    }
}
