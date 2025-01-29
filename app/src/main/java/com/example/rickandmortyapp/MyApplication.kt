package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.di.RickAndMortyModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val modulesList = listOf(
            RickAndMortyModule.dataModule,
            RickAndMortyModule.domainModule,
            RickAndMortyModule.presentationModule,
            RickAndMortyModule.networkModule,
            RickAndMortyModule.coroutineModule
        )

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(modulesList)
        }
    }
}