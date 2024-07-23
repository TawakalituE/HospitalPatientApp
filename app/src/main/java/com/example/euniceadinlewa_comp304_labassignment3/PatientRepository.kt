package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData

class PatientRepository(private val patientDao: PatientDao) {
    val allPatients: LiveData<List<Patient>> = patientDao.getAllPatients()

    suspend fun insert(patient: Patient): Long {
        return patientDao.insert(patient)
    }

    suspend fun update(patient: Patient) {
        patientDao.update(patient)
    }

    suspend fun delete(patient: Patient) {
        patientDao.delete(patient)
    }

    fun getPatientById(id: Int): LiveData<Patient> {
        return patientDao.getPatientById(id)
    }
}
