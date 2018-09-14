package com.example.admin.deltachallenge.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.example.admin.deltachallenge.AppController
import com.example.admin.deltachallenge.data.repository.Repository
import javax.inject.Inject

class MainViewModel(context: Application) : AndroidViewModel(context) {

    @Inject
    lateinit var repository: Repository

    init {
        (context as AppController).getComponent().inject(this)
    }

    fun getRandomNumbers(): LiveData<List<Int>> {
        repository.getRandomNumbers()
        return Transformations.map(repository.randomNumbersLiveData) {
            it.data.sort()
            it.data
        }
    }
}