package com.example.euniceadinlewa_comp304_labassignment3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
    @PrimaryKey(autoGenerate = true) val testId: Int = 0,
    val patientId: Int,
    val nurseId: Int,
    val BPL: Int,
    val BPH: Int,
    val temperature: Float,

)
