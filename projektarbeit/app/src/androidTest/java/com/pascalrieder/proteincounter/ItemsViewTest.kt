package com.pascalrieder.proteincounter

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ItemsViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun `Navigate to ItemsView`() {
        composeTestRule.onNodeWithTag("items").performClick()
    }

    @Test
    fun `Check if correct amount of items  exist`() {
        composeTestRule.waitUntil(10000) {
            (composeTestRule.activity.itemsViewModel.allItems.value?.count() ?: 0) == 1109
        }
    }

    @Test
    fun `Check if items can get expanded`() {
        val nodes = composeTestRule.onAllNodesWithTag("btn_expand_item")
        nodes.onFirst().assertIsDisplayed().performClick()
        nodes.onLast().assertIsDisplayed().performClick()
    }
}