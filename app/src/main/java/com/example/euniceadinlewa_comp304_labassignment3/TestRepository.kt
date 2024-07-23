package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData

class TestRepository(private val testDao: TestDao) {
    suspend fun insert(test: Test) {
        testDao.insert(test)
    }

    suspend fun update(test: Test) {
        testDao.update(test)
    }

    suspend fun delete(test: Test) {
        testDao.delete(test)
    }

    fun getTestById(id: Int): LiveData<Test> {
        return testDao.getTestById(id)
    }

    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>> {
        return testDao.getTestsByPatientId(patientId)
    }
}
