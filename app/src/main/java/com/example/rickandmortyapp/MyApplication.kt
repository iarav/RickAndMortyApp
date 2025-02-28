package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.characterDatails.di.CharacterDetaisRickAndMortyModule
import com.example.rickandmortyapp.common.di.CommonRickAndMortyModule
import com.example.rickandmortyapp.home.di.HomeRickAndMortyModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val modulesList = listOf(
            CommonRickAndMortyModule.dataModule,
            CommonRickAndMortyModule.domainModule,
            CommonRickAndMortyModule.networkModule,
            CommonRickAndMortyModule.coroutineModule,
            CharacterDetaisRickAndMortyModule.dataModule,
            CharacterDetaisRickAndMortyModule.domainModule,
            CharacterDetaisRickAndMortyModule.presentationModule,
            HomeRickAndMortyModule.dataModule,
            HomeRickAndMortyModule.domainModule,
            HomeRickAndMortyModule.presentationModule,

        )

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(modulesList)
        }
    }
}