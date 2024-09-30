package com.example.adoptapetapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adoptapetapp.databinding.ActivitySplashScreenBinding
import com.example.wauwau.databinding.ActivityLoginBinding
import com.example.wauwau.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.splashScreen.alpha = 0f
        binding.splashScreen.animate().setDuration(1500).alpha(0.5f).withEndAction {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

    }
}