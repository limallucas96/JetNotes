package di

import androidx.room.Room
import database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import repository.NotesRepositoryContract
import repository.local.NotesRepository

private val dataBaseModules = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "DATA_BASE_NAME"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().getNotesDataSource() }

}

private val repositoryModules = module {

    single<NotesRepositoryContract> {
        NotesRepository(notesDataSource = get())
    }

}

val dataModules = listOf(dataBaseModules, repositoryModules)