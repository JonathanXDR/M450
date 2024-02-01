package com.pascalrieder.proteincounter

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodayViewTest {/*
    * android.database.sqlite.SQLiteConstraintException: UNIQUE constraint failed: day.date (code 2067 SQLITE_CONSTRAINT_UNIQUE)
    * This error exists when the main activity launches and there are multiple attempts to insert
    * a day with the today's date. The error gets throws because the date is unique and
    * cant be inserted multiple times. It needs to get fixed but has nothing to do with the ui tests.
    *
    * Edit: The error gets caught and logged
    */


    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun `Whait until day is selected or created`() {
        composeTestRule.waitUntil(10000) {
            composeTestRule.onNodeWithText("Day not found").isNotDisplayed()
        }
    }

    @Test
    fun `Check if FAB exists`() {
        composeTestRule.onNodeWithContentDescription("Add Icon").assertIsDisplayed()
    }

    @Test
    fun `Check if FAB is clickable`() {
        composeTestRule.onNodeWithContentDescription("Add Icon").assertHasClickAction()
    }

    @Test
    fun `Check if protein target can be changed`() {
        composeTestRule.onNodeWithTag("btn_edit_protein").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("txt_protein_goal").assertIsDisplayed()
            .performTextInput("120")
        composeTestRule.onNodeWithText("Confirm").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("You've consumed 120 g of Protein.").assertIsDisplayed()
    }

    @Test
    fun `Check if kcal target can be changed`() {
        composeTestRule.onNodeWithTag("btn_edit_kcal").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("txt_kcal_goal").assertIsDisplayed().performTextInput("2500")
        composeTestRule.onNodeWithText("Confirm").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("You've consumed 2500 Kcal.").assertIsDisplayed()
    }

    @Test
    fun `Check if a new item can be added`() {
        composeTestRule.onNodeWithContentDescription("Add Icon").performClick()
        composeTestRule.onNodeWithTag("consumedAmount").performTextInput("150")
        composeTestRule.onNodeWithTag("item_1").performClick()

        // Assert that the item is displayed in the view
        composeTestRule.waitUntil(1000) { composeTestRule.onNodeWithText("150g").isDisplayed() }
        composeTestRule.onNodeWithText("150g").assertIsDisplayed()
    }
    @Test
    fun `Check if a new item can get deleted`() {
        // Expant item
        composeTestRule.onNodeWithTag("btn_expand_item_1").assertIsDisplayed().performClick()

        // Assert that item can be deleted
        composeTestRule.onNodeWithTag("btn_delete_item_1").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("150g").assertIsNotDisplayed()
    }
}