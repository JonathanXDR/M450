package com.pascalrieder.proteincounter

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class MainActivityTests {
    /*
    * android.database.sqlite.SQLiteConstraintException: UNIQUE constraint failed: day.date (code 2067 SQLITE_CONSTRAINT_UNIQUE)
    * This error exists when the main activity launches and there are multiple attempts to insert
    * a day with the today's date. The error gets throws because the date is unique and
    * cant be inserted multiple times. It needs to get fixed but has nothing to do with the ui tests.
    *
    * Edit: The error gets caught and logged
    */

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun `Check if FAB exists`() {
        composeTestRule.onNodeWithContentDescription("Add Icon").assertIsDisplayed()
    }

    @Test
    fun `Check if FAB is clickable`() {
        composeTestRule.onNodeWithContentDescription("Add Icon").assertHasClickAction()
    }

}