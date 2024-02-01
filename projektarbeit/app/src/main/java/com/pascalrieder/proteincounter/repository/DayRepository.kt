package com.pascalrieder.proteincounter.repository

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.pascalrieder.proteincounter.database.dao.DayDao
import com.pascalrieder.proteincounter.database.dto.DayWithItems
import com.pascalrieder.proteincounter.database.dto.DayWithItemsDb
import com.pascalrieder.proteincounter.database.dto.ItemFromDay
import com.pascalrieder.proteincounter.database.models.DayItem
import java.time.LocalDate

open class DayRepository(private val dayDao: DayDao) {
    private val allDaysWithItems: MediatorLiveData<List<DayWithItems>> = MediatorLiveData()
    private val todayWithItems: MediatorLiveData<DayWithItems> = MediatorLiveData()
    var onTodayNotFound: () -> Unit = {}

    init {
        allDaysWithItems.addSource(dayDao.readAllData()) { dbDays ->
            allDaysWithItems.value = dayEntriesToDayWithItems(dbDays)
        }
        todayWithItems.addSource(dayDao.readDayEntriesFromDate(LocalDate.now())) { dbDays ->
            val days = dayEntriesToDayWithItems(dbDays)
            if (days.isNotEmpty() && days.count() == 1) todayWithItems.value = days.first()
            else onTodayNotFound()
        }

    }

    fun getDaysWithItems(): LiveData<List<DayWithItems>> {
        return allDaysWithItems
    }

    fun getToday(onDayNotFound: () -> Unit = {}): LiveData<DayWithItems> {
        onTodayNotFound = onDayNotFound
        return todayWithItems
    }

    suspend fun removeItemFromDay(dayId: Long, itemId: Long) {
        dayDao.removeItemFromDay(dayId, itemId)
    }

    suspend fun addItemToDay(dayItem: DayItem) {
        dayDao.addItemToDay(
            itemId = dayItem.itemId,
            dayId = dayItem.dayId,
            amount = dayItem.amountInGram,
            isDeleted = dayItem.isDeleted
        )
    }

    @Throws(SQLiteConstraintException::class)
    suspend fun addDay(day: DayWithItems) {
        val a = dayDao.addDay(day.toDay())
        day.items.forEach {
            dayDao.addItemToDay(a, it.itemId, it.amountInGram, false)
        }
    }

    fun dayEntriesToDayWithItems(dayWithItemsDb: List<DayWithItemsDb>): MutableList<DayWithItems> {
        val days = mutableListOf<DayWithItems>()

        dayWithItemsDb.forEach { dbDay ->
            val existingDay = days.find { it.date == dbDay.date }

            if (existingDay == null) {
                val newDay = DayWithItems(dbDay.dayId, dbDay.date, mutableListOf())
                if (dbDay.itemId != null && dbDay.isDeleted != true) {
                    newDay.items.add(dbDay.toItemFromDay())
                }
                days.add(newDay)
            } else {
                if (dbDay.itemId != null && dbDay.isDeleted != true) {
                    existingDay.items.add(dbDay.toItemFromDay())
                }
            }
        }
        return days
    }

    private fun DayWithItemsDb.toItemFromDay(): ItemFromDay {
        return ItemFromDay(
            itemId = this.itemId ?: 0,
            name = this.name.orEmpty(),
            proteinContentPercentage = this.proteinContentPercentage ?: 0.0f,
            kcalContentIn100g = this.kcalContentIn100g ?: 0.0f,
            amountInGram = this.amountInGram ?: 0.0f
        )
    }

}