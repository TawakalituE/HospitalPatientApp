package com.example.euniceadinlewa_comp304_labassignment3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PatientViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PatientRepository
    val allPatients: LiveData<List<Patient>>

    init {
        val patientDao = AppDatabase.getDatabase(application).patientDao()
        repository = PatientRepository(patientDao)
        allPatients = repository.allPatients
    }

    fun insert(patient: Patient, onResult: (Long) -> Unit) = viewModelScope.launch {
        val newId = repository.insert(patient)
        onResult(newId)
    }

    fun update(patient: Patient) = viewModelScope.launch {
        repository.update(patient)
    }

    fun delete(patient: Patient) = viewModelScope.launch {
        repository.delete(patient)
    }

    fun getPatientById(id: Int): LiveData<Patient> {
        return repository.getPatientById(id)
    }
}
