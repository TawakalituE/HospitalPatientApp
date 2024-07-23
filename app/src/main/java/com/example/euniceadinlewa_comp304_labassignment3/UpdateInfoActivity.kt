package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityUpdateInfoBinding

class UpdateInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateInfoBinding
    private val patientViewModel: PatientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFetchPatient.setOnClickListener {
            val patientId = binding.etPatientId.text.toString().toIntOrNull()
            if (patientId != null) {
                patientViewModel.getPatientById(patientId).observe(this, { patient ->
                    patient?.let {
                        binding.etFirstName.setText(it.firstname)
                        binding.etLastName.setText(it.lastname)
                        binding.etDepartment.setText(it.department)
                        binding.etNurseId.setText(it.nurseId.toString())
                        binding.etRoom.setText(it.room)
                    } ?: run {
                        Toast.makeText(this, "Patient not found", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "Please enter a valid Patient ID", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnUpdatePatient.setOnClickListener {
            val patientId = binding.etPatientId.text.toString().toIntOrNull()
            if (patientId != null) {
                patientViewModel.getPatientById(patientId).observe(this, { patient ->
                    patient?.let {
                        it.firstname = binding.etFirstName.text.toString()
                        it.lastname = binding.etLastName.text.toString()
                        it.department = binding.etDepartment.text.toString()
                        it.nurseId = binding.etNurseId.text.toString().toInt()
                        it.room = binding.etRoom.text.toString()
                        patientViewModel.update(it)
                        Toast.makeText(this, "Patient updated successfully", Toast.LENGTH_SHORT).show()
                    } ?: run {
                        Toast.makeText(this, "Patient not found", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "Please enter a valid Patient ID", Toast.LENGTH_SHORT).show()
            }
        }

        // Adding a button to navigate back to the main screen
        binding.btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
