package com.example.euniceadinlewa_comp304_labassignment3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true) val patientId: Int = 0,
    var firstname: String,
    var lastname: String,
    var department: String,
    var nurseId: Int,
    var room: String
)
