package com.example.jetnotes.di

import com.example.jetnotes.ui.screen.listNotes.ListNotesScreenViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@InternalCoroutinesApi
val viewModelModules = module {
    viewModel { ListNotesScreenViewModel() }
}