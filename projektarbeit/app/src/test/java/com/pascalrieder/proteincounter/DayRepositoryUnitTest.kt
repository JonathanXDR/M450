package com.pascalrieder.proteincounter

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.pascalrieder.proteincounter.repository.DayRepository
import com.pascalrieder.proteincounter.database.dao.DayDao
import com.pascalrieder.proteincounter.database.dto.DayWithItems
import com.pascalrieder.proteincounter.database.dto.DayWithItemsDb
import com.pascalrieder.proteincounter.database.dto.ItemFromDay
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import java.time.LocalDate
import androidx.test.ext.junit.runners.AndroidJUnit4
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


@RunWith(AndroidJUnit4::class)
class DayWithItemUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dayDao: DayDao
    private lateinit var dayRepository: DayRepository
    private val fakeData = FakeData()

    @Before
    fun setUp() {
        dayDao = Mockito.mock(DayDao::class.java)

        val mockAllDataLiveData = MutableLiveData<List<DayWithItemsDb>>()
        mockAllDataLiveData.value = fakeData.dbDays.value
        Mockito.`when`(dayDao.readAllData()).thenReturn(mockAllDataLiveData)

        val mockTodayDataLiveData = MutableLiveData<List<DayWithItemsDb>>()
        Mockito.`when`(dayDao.readDayEntriesFromDate(LocalDate.now())).thenReturn(mockTodayDataLiveData)

        dayRepository = DayRepository(dayDao)
    }

    @Test
    fun `Test Get All Days`() {
        val observedData = dayRepository.getDaysWithItems().getOrAwaitValue()

        assertEquals(fakeData.days.size, observedData.size)
        for (i in fakeData.days.indices) {
            assertEquals(fakeData.days[i].date, observedData[i].date)
        }
    }
}

class FakeData {
    // Db Days are the records from the database
    val dbDays = MutableLiveData<List<DayWithItemsDb>>()

    // Days are the cleaned up records from the database returned by the repository
    val days: List<DayWithItems>

    init {
        dbDays.value = listOf(
            DayWithItemsDb(1, LocalDate.now(), null, null, null, null, null, null),
            DayWithItemsDb(2, LocalDate.now().minusDays(1), 2, "Item2", 20f, 200f, 40f, false),
            DayWithItemsDb(3, LocalDate.now().minusDays(2), 3, "Item3", 30f, 300f, 60f, false),
        )
        days = listOf(
            DayWithItems(
                1, LocalDate.now(), mutableListOf()
            ),
            DayWithItems(
                2, LocalDate.now().minusDays(1), mutableListOf(
                    ItemFromDay(
                        2, "Item2", 20f, 200f, 40f
                    )
                )
            ),
            DayWithItems(
                3, LocalDate.now().minusDays(2), mutableListOf(
                    ItemFromDay(
                        3, "Item3", 30f, 300f, 60f
                    )
                )
            )
        )
    }
}

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = Observer<T> { o ->
        data = o
        latch.countDown()
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}
