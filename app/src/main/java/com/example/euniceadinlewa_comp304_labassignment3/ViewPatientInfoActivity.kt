package com.example.euniceadinlewa_comp304_labassignment3

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityViewPatientInfoBinding

class ViewPatientInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPatientInfoBinding
    private val patientViewModel: PatientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPatientInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnViewPatients.setOnClickListener {
            Log.d("ViewPatientInfoActivity", "View Patient button clicked")
            val patientId = binding.etPatientId.text.toString().toIntOrNull()
            if (patientId != null) {
                patientViewModel.getPatientById(patientId).observe(this, { patient ->
                    patient?.let {
                        binding.tvPatientDetails.text = """
                            ID: ${it.patientId}
                            First Name: ${it.firstname}
                            Last Name: ${it.lastname}
                            Department: ${it.department}
                            Nurse ID: ${it.nurseId}
                            Room: ${it.room}
                        """.trimIndent()
                    }
                })
            } else {
                binding.tvPatientDetails.text = "Please enter a valid Patient ID"
            }
        }
    }
}
