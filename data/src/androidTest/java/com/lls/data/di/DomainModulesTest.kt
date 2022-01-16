package com.lls.data.di

import org.koin.dsl.module
import usecases.notes.NotesUseCase
import usecases.notes.NotesUseCaseContract

private val useCaseModulesMock = module {

    single<NotesUseCaseContract> {
        NotesUseCase(notesRepository = get())
    }

}

val domainModulesMock = listOf(useCaseModulesMock)