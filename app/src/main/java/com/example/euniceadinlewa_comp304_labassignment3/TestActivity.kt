package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveTest.setOnClickListener {
            Log.d("TestActivity", "Save Test button clicked")
            val test = Test(
                patientId = binding.etPatientId.text.toString().toInt(),
                nurseId = binding.etNurseId.text.toString().toInt(),
                BPL = binding.etBPL.text.toString().toInt(),
                BPH = binding.etBPH.text.toString().toInt(),
                temperature = binding.etTemperature.text.toString().toFloat()
            )
            testViewModel.insert(test)
            showCustomToast("Test data added successfully")
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
