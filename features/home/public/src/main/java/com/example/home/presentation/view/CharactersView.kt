package com.example.home.presentation.view

import androidx.compose.runtime.Composable
import com.example.home.presentation.viewmodel.CharactersViewModel
import org.koin.androidx.compose.koinViewModel

abstract class CharactersView {
    @Composable
    abstract fun CharactersListView(viewModel: CharactersViewModel)

    @Composable
    fun Render(){
        val viewModel: CharactersViewModel = koinViewModel()
        CharactersListView(viewModel)
    }
}