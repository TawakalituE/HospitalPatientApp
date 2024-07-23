package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(test: Test)

    @Update
    suspend fun update(test: Test)

    @Delete
    suspend fun delete(test: Test)

    @Query("SELECT * FROM Test WHERE testId = :id")
    fun getTestById(id: Int): LiveData<Test>

    @Query("SELECT * FROM Test WHERE patientId = :patientId")
    fun getTestsByPatientId(patientId: Int): LiveData<List<Test>>
}
