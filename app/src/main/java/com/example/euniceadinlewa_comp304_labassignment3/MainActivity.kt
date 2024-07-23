package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnPatient.setOnClickListener {
            startActivity(Intent(this, PatientActivity::class.java))
        }

        binding.btnTest.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }

        binding.btnViewTestInfo.setOnClickListener {
            startActivity(Intent(this, ViewTestInfoActivity::class.java))
        }

        binding.btnUpdateInfo.setOnClickListener {
            startActivity(Intent(this, UpdateInfoActivity::class.java))
        }
    }
}
