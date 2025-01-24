package com.example.tasksanj.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksanj.databinding.ActivitySplashTaskBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

            startActivity(Intent(this@SplashTaskActivity, MainActivity::class.java))


        }


    }
}