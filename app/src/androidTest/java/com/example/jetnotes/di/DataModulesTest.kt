package com.example.jetnotes.di

import androidx.room.Room
import database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import repository.NotesRepositoryContract
import repository.local.NotesRepository

private val dataBaseModulesMock = module {

    single {
        Room.inMemoryDatabaseBuilder(
            androidContext(),
            AppDatabase::class.java
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().getNotesDataSource() }

}

private val repositoryModulesMock = module {

    single<NotesRepositoryContract> {
        NotesRepository(notesDataSource = get())
    }

}

val dataModulesMock = listOf(dataBaseModulesMock, repositoryModulesMock)