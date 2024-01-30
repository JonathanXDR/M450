package com.pascalrieder.proteincounter

import androidx.lifecycle.MutableLiveData
import com.m335pascal.repository.DayRepository
import com.pascalrieder.proteincounter.database.dao.DayDao
import com.pascalrieder.proteincounter.database.dto.DayWithItems
import com.pascalrieder.proteincounter.database.dto.DayWithItemsDb
import com.pascalrieder.proteincounter.database.dto.ItemFromDay
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.time.LocalDate

class FakeData() {
    // Db Days are the records from the database
    val dbDays = MutableLiveData<List<DayWithItemsDb>>()

    // Days are the cleaned up records from the database returned by the repository
    val days: List<DayWithItems>

    init {
        dbDays.value = listOf(
            DayWithItemsDb(1, LocalDate.now(), null, null, null, null, null, null),
            DayWithItemsDb(2, LocalDate.now(), 2, "Item2", 20f, 200f, 40f, false),
            DayWithItemsDb(3, LocalDate.now(), 3, "Item3", 30f, 300f, 60f, false),
        )
        days = List(3) {
            DayWithItems(
                1, LocalDate.now(), mutableListOf()
            )
            DayWithItems(
                2, LocalDate.now(), mutableListOf(
                    ItemFromDay(
                        2, "Item2", 20f, 200f, 40f
                    )
                )
            )
            DayWithItems(
                3, LocalDate.now(), mutableListOf(
                    ItemFromDay(
                        3, "Item3", 30f, 300f, 60f
                    )
                )
            )
        }
    }
}

class DayWithItemUnitTest {
    private lateinit var dayDao: DayDao
    private lateinit var dayRepository: DayRepository
    private val fakeData = FakeData()


    @Before
    fun setUp() {
        dayDao = Mockito.mock(DayDao::class.java)
        Mockito.`when`(dayDao.readAllData()).thenReturn(fakeData.dbDays)
        dayRepository = DayRepository(dayDao)
    }

    @Test
    fun `Test Get All Days`() {
        assertEquals(fakeData.days, dayRepository.getDaysWithItems().value)
    }
}