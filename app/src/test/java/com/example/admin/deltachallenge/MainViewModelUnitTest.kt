package com.example.admin.deltachallenge

import android.arch.lifecycle.Observer
import com.example.admin.deltachallenge.data.repository.Repository
import com.example.admin.deltachallenge.ui.MainViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelUnitTest {

    @Mock
    lateinit var observer: Observer<List<Int>>
    @Mock
    lateinit var argumentCaptor: ArgumentCaptor<List<Int>>
    @Spy
    lateinit var context: AppController
    @Mock
    lateinit var repository: Repository
    @InjectMocks
    lateinit var mainViewModel: MainViewModel

    @Test
    fun listLiveData_isUpdated() {
        mainViewModel.getRandomNumbers().observeForever(observer)
        verify(observer).onChanged(argumentCaptor.capture())
    }

    @After
    fun tearDown() {
        mainViewModel.getRandomNumbers().removeObserver(observer)
    }
}