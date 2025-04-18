package com.example.common.di

import com.example.common.data.api.CharacterApi
import com.example.common.data.mapper.CharacterDetailsMapper
import com.example.common.data.mapper.CharactersMapper
import com.example.common.data.repository.CharacterRepositoryImpl
import com.example.common.domain.mapper.CharacterPresentationMapper
import com.example.common.domain.repository.CharacterRepository
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
        factory { CharacterDetailsMapper() }
        factory { CharactersMapper() }
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
