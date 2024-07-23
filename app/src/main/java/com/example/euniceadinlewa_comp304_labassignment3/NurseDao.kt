package com.example.euniceadinlewa_comp304_labassignment3

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NurseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(nurse: Nurse)

    @Update
    suspend fun update(nurse: Nurse)

    @Delete
    suspend fun delete(nurse: Nurse)

    @Query("SELECT * FROM Nurse WHERE nurseId = :id")
    fun getNurseById(id: Int): LiveData<Nurse>

    @Query("SELECT * FROM Nurse WHERE nurseId = :id AND password = :password")
    suspend fun login(id: Int, password: String): Nurse?
}
