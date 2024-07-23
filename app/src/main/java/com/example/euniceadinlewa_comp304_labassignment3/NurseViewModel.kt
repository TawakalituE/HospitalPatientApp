package com.example.euniceadinlewa_comp304_labassignment3

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NurseViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NurseRepository

    init {
        val nurseDao = AppDatabase.getDatabase(application).nurseDao()
        repository = NurseRepository(nurseDao)
    }

    fun insert(nurse: Nurse) = viewModelScope.launch {
        repository.insert(nurse)
    }

    fun update(nurse: Nurse) = viewModelScope.launch {
        repository.update(nurse)
    }

    fun delete(nurse: Nurse) = viewModelScope.launch {
        repository.delete(nurse)
    }

    fun getNurseById(id: Int): LiveData<Nurse> {
        return repository.getNurseById(id)
    }

    fun login(id: Int, password: String): LiveData<Nurse?> = liveData {
        val nurse = repository.login(id, password)
        emit(nurse)
    }
}
