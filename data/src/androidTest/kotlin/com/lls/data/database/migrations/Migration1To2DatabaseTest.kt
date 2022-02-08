package com.lls.data.database.migrations

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lls.data.database.MigrationOneToTwoMockProvider.INITIAL_NOTE
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_COLOR
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_DATE_STAMP
import com.lls.data.database.MigrationOneToTwoMockProvider.MIGRATION_NOTE
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_COLOR_COLUMN
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_DATE_COLUMN
import com.lls.data.database.MigrationOneToTwoMockProvider.NOTE_TEXT_COLUMN
import com.lls.data.database.bases.AppBaseDatabaseTest
import database.DbConstants.DATA_BASE_NAME
import database.DbConstants.TABLE_NAME_NOTES
import database.migrations.MIGRATION_1_2
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class Migration1To2DatabaseTest : AppBaseDatabaseTest() {

    private lateinit var database: SupportSQLiteDatabase

    @Before
    @Throws(IOException::class)
    fun setUp() {
        database = migrationTestHelper.createDatabase(DATA_BASE_NAME, 1)
    }

    @Test
    @Throws(IOException::class)
    fun migrationOneToTwoTest() {

        var assertInitialNote = ""
        var assertMigrationNote = ""
        var assertMigrationColor = ""
        var assertMigrationDateStamp = ""
        var assertInitialNoteAfterMigration = ""

        database.execSQL("INSERT INTO $TABLE_NAME_NOTES ($NOTE_TEXT_COLUMN) VALUES ('$INITIAL_NOTE')")

        database.query("SELECT * FROM $TABLE_NAME_NOTES")?.run {

            while (moveToNext()) {
                assertInitialNote = getString(getColumnIndex(NOTE_TEXT_COLUMN))
            }

            database.close()
            close()

        }

        database = migrationTestHelper.runMigrationsAndValidate(DATA_BASE_NAME, 2, true, MIGRATION_1_2)

        database.execSQL("INSERT INTO $TABLE_NAME_NOTES ($NOTE_TEXT_COLUMN,$NOTE_COLOR_COLUMN,$NOTE_DATE_COLUMN) VALUES ('$MIGRATION_NOTE','$MIGRATION_COLOR','$MIGRATION_DATE_STAMP')")

        database.query("SELECT * FROM $TABLE_NAME_NOTES")?.run {

            while (moveToNext()) {
                if (position == 0) {
                    assertInitialNoteAfterMigration = getString(getColumnIndex(NOTE_TEXT_COLUMN))
                } else {
                    assertMigrationNote = getString(getColumnIndex(NOTE_TEXT_COLUMN))
                    assertMigrationColor = getString(getColumnIndex(NOTE_COLOR_COLUMN))
                    assertMigrationDateStamp = getString(getColumnIndex(NOTE_DATE_COLUMN))
                }
            }

            database.close()
            close()
        }

        assertEquals(assertInitialNote, INITIAL_NOTE)
        assertEquals(assertInitialNoteAfterMigration, INITIAL_NOTE)
        assertEquals(assertMigrationNote, MIGRATION_NOTE)
        assertEquals(assertMigrationColor, MIGRATION_COLOR)
        assertEquals(assertMigrationDateStamp, MIGRATION_DATE_STAMP)
    }

}