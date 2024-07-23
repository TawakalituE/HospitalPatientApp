package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityViewTestInfoBinding

class ViewTestInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewTestInfoBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewTestInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnViewTests.setOnClickListener {
            val patientId = binding.etPatientId.text.toString().toInt()
            testViewModel.getTestsByPatientId(patientId).observe(this, { tests ->
                val testDetails = StringBuilder()
                for (test in tests) {
                    testDetails.append("Test ID: ${test.testId}\n")
                    testDetails.append("Patient ID: ${test.patientId}\n")
                    testDetails.append("Nurse ID: ${test.nurseId}\n")
                    testDetails.append("BPL: ${test.BPL}\n")
                    testDetails.append("BPH: ${test.BPH}\n")
                    testDetails.append("Temperature: ${test.temperature}\n")
                    testDetails.append("\n")
                }
                binding.tvTestDetails.text = testDetails.toString()
            })
        }

        binding.btnBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
