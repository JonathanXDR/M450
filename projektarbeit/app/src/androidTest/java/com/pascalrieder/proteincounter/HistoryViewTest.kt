package com.pascalrieder.proteincounter

import android.os.Environment
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.File

class HistoryViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun `Navigate to HistoryView`() {
        composeTestRule.onNodeWithTag("history").performClick()
    }

    @Test
    fun `Check if backup can get created`() {
        val backupName = "DatabaseBackup${System.currentTimeMillis()}"
        val destinationDirectory =
            "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)}/ProteinCounterBackups/"

        val backupDirectory = File(destinationDirectory)
        val initialFileCount = backupDirectory.listFiles()?.size ?: 0

        composeTestRule.onNodeWithTag("btn_create_backup").performClick()

        val updatedFileCount = backupDirectory.listFiles()?.size ?: 0

        assert(updatedFileCount == initialFileCount + 1) {
            "Expected ${initialFileCount + 1} files in the backup directory, but found $updatedFileCount files."
        }
    }
}