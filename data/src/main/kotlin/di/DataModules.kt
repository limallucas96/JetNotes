package di

import androidx.room.Room
import local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val dataBaseModules = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "DATA_BASE_NAME")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().getNotesDataSource() }

}

val dataModules = listOf(dataBaseModules)