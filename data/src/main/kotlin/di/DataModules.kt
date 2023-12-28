package di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import database.AppDatabase
import database.DbConstants.DATA_BASE_NAME
import database.datasource.NotesDataSource
import database.migrations.MIGRATION_1_2
import repository.NotesRepositoryContract
import repository.local.NotesRepository
import usecases.notes.NotesUseCase
import usecases.notes.NotesUseCaseContract
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModules {

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATA_BASE_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Singleton
    @Provides
    fun providesNotesDataSource(appDatabase: AppDatabase): NotesDataSource {
        return appDatabase.getNotesDataSource()
    }

    @Singleton
    @Provides
    fun providesNotesRepository(notesDataSource: NotesDataSource): NotesRepositoryContract {
        return NotesRepository(notesDataSource)
    }

    @Singleton
    @Provides
    fun providesNotesUseCase(notesRepositoryContract: NotesRepositoryContract) : NotesUseCaseContract {
        return NotesUseCase(notesRepositoryContract)
    }

}