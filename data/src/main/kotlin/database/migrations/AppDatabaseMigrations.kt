package database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import database.DbConstants.TABLE_NAME_NOTES

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE $TABLE_NAME_NOTES ADD COLUMN color TEXT")
        database.execSQL("ALTER TABLE $TABLE_NAME_NOTES ADD COLUMN date TEXT")
    }
}