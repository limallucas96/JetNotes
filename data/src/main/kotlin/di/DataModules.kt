package di

import androidx.room.Room
import database.AppDatabase
import database.DbConstants.DATA_BASE_NAME
import database.migrations.MIGRATION_1_2
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import repository.NotesRepositoryContract
import repository.local.NotesRepository

private val dataBaseModules = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATA_BASE_NAME
        )
            .addMigrations(MIGRATION_1_2)
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