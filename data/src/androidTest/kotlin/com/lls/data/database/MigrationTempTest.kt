package com.lls.data.database

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.lls.data.database.MigrationOneToTwoMockProvider.INITIAL_NOTE
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_COLOR
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_DATE_STAMP
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_NOTE
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_COLOR_COLUMN
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_DATE_COLUMN
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_TEXT_COLUMN
import database.DbConstants.DATA_BASE_NAME
import database.DbConstants.TABLE_NAME_NOTES
import database.migrations.MIGRATION_1_2
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MigrationTempTest {

    private lateinit var supportSQLiteDatabase: SupportSQLiteDatabase

    @get:Rule
    var migrationTestHelper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        database.AppDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Before
    @Throws(IOException::class)
    fun setUp() {
        supportSQLiteDatabase = migrationTestHelper.createDatabase(DATA_BASE_NAME, 1)
    }

    @Test
    @Throws(IOException::class)
    fun originalDatabaseTest() {

        var assertInitialNote = ""
        var assertMigrationNote = ""
        var assertMigrationColor = ""
        var assertMigrationDateStamp = ""
        var assertInitialNoteAfterMigration = ""

        supportSQLiteDatabase.execSQL("INSERT INTO $TABLE_NAME_NOTES ($NOTE_TEXT_COLUMN) VALUES ('$INITIAL_NOTE')")

        val initialCursor = supportSQLiteDatabase?.query("SELECT * FROM $TABLE_NAME_NOTES")

        while (initialCursor?.moveToNext() == true) {
            assertInitialNote = initialCursor.getString(initialCursor.getColumnIndex(NOTE_TEXT_COLUMN))
        }

        supportSQLiteDatabase.close()
        initialCursor?.close()

        supportSQLiteDatabase = migrationTestHelper.runMigrationsAndValidate(DATA_BASE_NAME, 2, true, MIGRATION_1_2)

        supportSQLiteDatabase.execSQL("INSERT INTO $TABLE_NAME_NOTES ($NOTE_TEXT_COLUMN,$NOTE_COLOR_COLUMN,$NOTE_DATE_COLUMN) VALUES ('$MIGRATION_NOTE','$MIGRATION_COLOR','$MIGRATION_DATE_STAMP')")

        val migrationCursor = supportSQLiteDatabase.query("SELECT * FROM $TABLE_NAME_NOTES")

        while (migrationCursor?.moveToNext() == true) {
            if (migrationCursor.position == 0) {
                assertInitialNoteAfterMigration =
                    migrationCursor.getString(migrationCursor.getColumnIndex(NOTE_TEXT_COLUMN))
            } else {
                assertMigrationNote = migrationCursor.getString(migrationCursor.getColumnIndex(NOTE_TEXT_COLUMN))
                assertMigrationColor = migrationCursor.getString(migrationCursor.getColumnIndex(NOTE_COLOR_COLUMN))
                assertMigrationDateStamp = migrationCursor.getString(migrationCursor.getColumnIndex(NOTE_DATE_COLUMN))
            }
        }

        supportSQLiteDatabase.close()
        migrationCursor?.close()

        assertEquals(assertInitialNote, INITIAL_NOTE)
        assertEquals(assertInitialNoteAfterMigration, INITIAL_NOTE)
        assertEquals(assertMigrationNote, MIGRATION_NOTE)
        assertEquals(assertMigrationColor, MIGRATION_COLOR)
        assertEquals(assertMigrationDateStamp, MIGRATION_DATE_STAMP)
    }

}