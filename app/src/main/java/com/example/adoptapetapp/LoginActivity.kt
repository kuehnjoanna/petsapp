package com.example.adoptapetapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adoptapetapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.main.alpha = 0.5f
        binding.main.animate().setDuration(1500).alpha(1f)



    }
}