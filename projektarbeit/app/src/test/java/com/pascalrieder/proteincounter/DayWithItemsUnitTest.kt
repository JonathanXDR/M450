package com.pascalrieder.proteincounter

import com.pascalrieder.proteincounter.database.dto.DayWithItems
import com.pascalrieder.proteincounter.database.dto.ItemFromDay
import org.junit.Test
import java.time.LocalDate

class DayWithItemsUnitTest {
    @Test
    fun `DayWithItems toDay`() {
        val dayWithItems = DayWithItems(
            dayId = 0, date = LocalDate.now()
        )
        val day = dayWithItems.toDay()

        assert(day.uid == 0L)
        assert(day.date == LocalDate.now())
    }

    @Test
    fun `DayWithItems getFormattedDate`() {
        val dayWithItems = DayWithItems(
            dayId = 0, date = LocalDate.of(2021, 1, 1)
        )
        val formattedDate = dayWithItems.getFormattedDate()

        assert(formattedDate == "01.01.2021")
    }

    @Test
    fun `DayWithItems getKcalTotal no items`() {
        val dayWithoutItems = DayWithItems(
            dayId = 0, date = LocalDate.now()
        )
        val kcalTotal = dayWithoutItems.getKcalTotal()

        assert(kcalTotal == 0f)
    }

    // Test object with 2 items
    private val dayWithItems = DayWithItems(
        dayId = 0, date = LocalDate.now(), items = mutableListOf(
            ItemFromDay(
                itemId = 0,
                name = "Item1",
                proteinContentPercentage = 8f,
                kcalContentIn100g = 120f,
                amountInGram = 80f
            ), ItemFromDay(
                itemId = 1,
                name = "Item2",
                proteinContentPercentage = 5f,
                kcalContentIn100g = 150f,
                amountInGram = 120f
            )
        )
    )

    @Test
    fun `DayWithItems getKcalTotal 2 items`() {
        val kcalTotal = dayWithItems.getKcalTotal()
        assert(kcalTotal == 276f)
    }

    @Test
    fun `DayWithItems getProteinTotal`() {
        val proteinTotal = dayWithItems.getProteinTotal()
        assert(proteinTotal == 12.4f)
    }

    @Test
    fun `ItemFromDay getProteinContentInGram`() {
        val itemFromDay = ItemFromDay(
            itemId = 0,
            name = "Item1",
            proteinContentPercentage = 8f,
            kcalContentIn100g = 120f,
            amountInGram = 80f
        )
        val proteinContentInGram = itemFromDay.getProteinContentInGram()

        // floating-point precision issues
        assert(proteinContentInGram == 6.3999996f)
    }

    @Test
    fun `ItemFromDay getKcalContent`() {
        val itemFromDay = ItemFromDay(
            itemId = 0,
            name = "Item1",
            proteinContentPercentage = 8f,
            kcalContentIn100g = 120f,
            amountInGram = 80f
        )
        val kcalContent = itemFromDay.getKcalContent()

        assert(kcalContent == 96f)
    }
}