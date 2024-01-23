package com.pascalrieder.proteincounter

import android.app.Application
import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.m335pascal.repository.DayRepository
import com.pascalrieder.proteincounter.database.AppDatabase
import com.pascalrieder.proteincounter.repository.ItemRepository
import com.pascalrieder.proteincounter.viewmodel.TodayViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class TodayViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule();

    private lateinit var viewModel: TodayViewModel;
    private lateinit var itemRepository: ItemRepository;
    private lateinit var dayRepository: DayRepository;

    @Before
    fun setup() {
        val application = mock(Application::class.java);
        val itemDao = AppDatabase.getDatabase(application).itemDao()
        itemRepository = ItemRepository(itemDao)

        val dayDao = AppDatabase.getDatabase(application).dayDao()
        dayRepository = DayRepository(dayDao)

        viewModel = TodayViewModel(application).apply {
        }
    }

    private val testDispatcher = StandardTestDispatcher();
    private val testCoroutineScope = TestScope(testDispatcher);

    @Test
    fun test_insertItem_with_valid_data(): Unit = testCoroutineScope.runTest {
        // Given
        viewModel.amountInGram = "100";
        val itemId = 1L;

        // When
        viewModel.insertItem(itemId);

        // Then
        val items = itemRepository.readAllData.value
        verify(items.orEmpty().any { it.uid == itemId })
    }

    /*    @Test
       fun `test insertItem with empty amount`() = testCoroutineScope.runBlockingTest {
           // Given
           viewModel.amountInGram = "";

           // When
           viewModel.insertItem(1L);

           // Then
           verify(dayRepository).addItemToDay(any());
           assert(viewModel.errorMessage == "Please enter an amount");
           assert(viewModel.openBottomSheet);
       }

       @Test
       fun `test removeItemFromToday`() = testCoroutineScope.runBlockingTest {
           // Given
           val item = Item(itemId = 1, itemName = "Item 1");
           val itemFromDay = ItemFromDay(item = item, amountInGram = 100f, isDeleted = false);

           // When
           viewModel.removeItemFromToday(itemFromDay);

           // Then
           verify(dayRepository).removeItemFromDay(eq(viewModel.dayWithItems.value!!.dayId), eq(item.itemId));
       }*/
}
