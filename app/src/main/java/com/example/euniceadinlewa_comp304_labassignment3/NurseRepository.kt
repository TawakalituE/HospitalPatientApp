package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData

class NurseRepository(private val nurseDao: NurseDao) {
    suspend fun insert(nurse: Nurse) {
        nurseDao.insert(nurse)
    }

    suspend fun update(nurse: Nurse) {
        nurseDao.update(nurse)
    }

    suspend fun delete(nurse: Nurse) {
        nurseDao.delete(nurse)
    }

    fun getNurseById(id: Int): LiveData<Nurse> {
        return nurseDao.getNurseById(id)
    }

    suspend fun login(id: Int, password: String): Nurse? {
        return nurseDao.login(id, password)
    }
}
