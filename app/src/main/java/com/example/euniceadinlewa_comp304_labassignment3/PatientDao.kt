package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: Patient): Long

    @Update
    suspend fun update(patient: Patient)

    @Delete
    suspend fun delete(patient: Patient)

    @Query("SELECT * FROM Patient WHERE patientId = :id")
    fun getPatientById(id: Int): LiveData<Patient>

    @Query("SELECT * FROM Patient")
    fun getAllPatients(): LiveData<List<Patient>>
}
