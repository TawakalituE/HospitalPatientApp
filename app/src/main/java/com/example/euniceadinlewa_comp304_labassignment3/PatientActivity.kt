package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityPatientBinding

class PatientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPatientBinding
    private val patientViewModel: PatientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val nurseId = sharedPref.getInt("nurseId", -1)

        binding.btnSavePatient.setOnClickListener {
            Log.d("PatientActivity", "Save Patient button clicked")
            val patient = Patient(
                firstname = binding.etFirstName.text.toString(),
                lastname = binding.etLastName.text.toString(),
                department = binding.etDepartment.text.toString(),
                nurseId = nurseId,
                room = binding.etRoom.text.toString()
            )
            patientViewModel.insert(patient) { newId ->
                runOnUiThread {
                    showCustomToast("Patient added successfully with ID: $newId")
                }
            }
        }

        binding.btnViewPatient.setOnClickListener {
            Log.d("PatientActivity", "View Patient button clicked")
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

        binding.btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showCustomToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()

        val handler = android.os.Handler()
        val numberOfRepetitions = 5
        for (i in 1..numberOfRepetitions) {
            handler.postDelayed({
                toast.show()
            }, (i * 3500).toLong())
        }
    }
}
