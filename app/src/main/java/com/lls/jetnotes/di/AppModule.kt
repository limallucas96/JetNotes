package com.lls.jetnotes.di

import com.lls.jetnotes.ui.screen.createNote.CreateNoteScreenViewModel
import com.lls.jetnotes.ui.screen.listNotes.ListNotesScreenViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@InternalCoroutinesApi
private val viewModelModules = module {
    viewModel { ListNotesScreenViewModel(get()) }
    viewModel { CreateNoteScreenViewModel(get()) }
}

@InternalCoroutinesApi
val appModules = listOf(viewModelModules)