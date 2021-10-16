package di

import org.koin.dsl.module
import usecases.notes.NotesUseCase
import usecases.notes.NotesUseCaseContract

private val repositoryModules = module {

    single<NotesUseCaseContract> {
        NotesUseCase(notesRepository = get())
    }

}

val domainModules = listOf(repositoryModules)
