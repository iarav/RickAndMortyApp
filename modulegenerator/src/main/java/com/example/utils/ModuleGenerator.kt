package com.example.utils

import com.example.characterdetails.di.CharacterDetaisRickAndMortyModule
import com.example.common.di.CommonRickAndMortyModule
import com.example.home.di.HomeRickAndMortyModule
import org.koin.core.module.Module

class ModuleGenerator {
    fun generateModules(): List<Module> {
        val modulesList = listOf(
            CommonRickAndMortyModule.dataModule,
            CommonRickAndMortyModule.domainModule,
            CommonRickAndMortyModule.networkModule,
            CommonRickAndMortyModule.coroutineModule,
            CharacterDetaisRickAndMortyModule.domainModule,
            CharacterDetaisRickAndMortyModule.presentationModule,
            HomeRickAndMortyModule.domainModule,
            HomeRickAndMortyModule.presentationModule,
        )

        return modulesList
    }
}
