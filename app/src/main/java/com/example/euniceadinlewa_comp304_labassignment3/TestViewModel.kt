package com.example.euniceadinlewa_comp304_labassignment3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TestRepository

    init {
        val testDao = AppDatabase.getDatabase(application).testDao()
        repository = TestRepository(testDao)
    }

    fun insert(test: Test) = viewModelScope.launch {
        repository.insert(test)
    }

    fun update(test: Test) = viewModelScope.launch {
        repository.update(test)
    }

    fun delete(test: Test) = viewModelScope.launch {
        repository.delete(test)
    }

    fun getTestById(id: Int): LiveData<Test> {
        return repository.getTestById(id)
    }

    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>> {
        return repository.getTestsByPatientId(patientId)
    }
}
