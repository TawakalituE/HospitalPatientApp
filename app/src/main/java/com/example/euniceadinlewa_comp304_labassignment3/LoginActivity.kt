package com.example.euniceadinlewa_comp304_labassignment3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.euniceadinlewa_comp304_labassignment3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val nurseViewModel: NurseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val nurseId = binding.etNurseId.text.toString().toInt()
            val password = binding.etPassword.text.toString()

            nurseViewModel.login(nurseId, password).observe(this, { nurse ->
                if (nurse != null) {
                    val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putInt("nurseId", nurseId)
                        apply()
                    }
                    showCustomToast("Login successful")
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun showCustomToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()

        val handler = android.os.Handler()
        val numberOfRepetitions = 3
        for (i in 1..numberOfRepetitions) {
            handler.postDelayed({
                toast.show()
            }, (i * 3500).toLong())
        }
    }
}
