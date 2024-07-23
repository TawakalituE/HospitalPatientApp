package com.example.euniceadinlewa_comp304_labassignment3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nurse(
    @PrimaryKey val nurseId: Int,
    val firstname: String,
    val lastname: String,
    val department: String,
    val password: String
)
