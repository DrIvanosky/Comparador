package com.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.comparador.views.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instanstTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparador.value?.resultado
        assertEquals("Seran o no Seran?", value)
    }

    @Test
    fun mainViewModel_ActionTestTrue() = runTest{
        launch {
            viewModel.comparar("Prueva1", "Prueva1")

        }

        advanceUntilIdle()

        val value = viewModel.comparador.value?.resultado
        assertEquals("Son Iguales", value)
    }

    @Test
    fun mainViewModel_ActionTestFalse() = runTest{
        launch {
            viewModel.comparar("Prueva", "Prueva1")

        }

        advanceUntilIdle()

        val value = viewModel.comparador.value?.resultado
        assertEquals("Son Distintas", value)
    }

}