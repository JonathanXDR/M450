package com.pascalrieder.proteincounter

import android.app.Application
import com.pascalrieder.proteincounter.viewmodel.TodayViewModel
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class TodayViewModelUnitTest {
    private val viewModel = TodayViewModel(mock(Application::class.java))

    @Test
    fun text_isFloat_isCorrect() {
        val isFloat = viewModel.isFloat("No Float")
        assertEquals(false, isFloat)
    }

    @Test
    fun float_isFloat_isCorrect() {
        val isFloat = viewModel.isFloat("1.0")
        assertEquals(true, isFloat)
    }

    @Test
    fun int_isFloat_isCorrect() {
        val isFloat = viewModel.isFloat("1")
        assertEquals(true, isFloat)
    }
}