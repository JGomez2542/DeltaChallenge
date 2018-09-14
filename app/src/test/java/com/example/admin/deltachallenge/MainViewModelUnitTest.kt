package com.example.admin.deltachallenge

import android.arch.lifecycle.Observer
import com.example.admin.deltachallenge.ui.MainViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class MainViewModelUnitTest(var mainViewModel: MainViewModel) {

    @Mock
    lateinit var observer: Observer<List<Int>>

    lateinit var numberList: List<Int>

    @Before
    fun setUp() {
        numberList = emptyList()
    }

    @Test
    fun listLiveData_isUpdated() {
        mainViewModel.getRandomNumbers().observeForever(observer)
        verify(observer).onChanged(numberList)
    }
}