package com.example.jetnotes.di

import androidx.room.Room
import com.example.jetnotes.data.AppDatabase
import com.example.jetnotes.ui.screen.createNote.CreateNoteScreenViewModel
import com.example.jetnotes.ui.screen.listNotes.ListNotesScreenViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@InternalCoroutinesApi
val viewModelModules = module {
    viewModel { ListNotesScreenViewModel(get()) }
    viewModel { CreateNoteScreenViewModel(get()) }
}

val databaseModules = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().getNotesDataSource() }

}

//TODO: set this in build gradle
private const val DATA_BASE_NAME = "jetnotes_database"