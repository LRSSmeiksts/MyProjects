package com.example.tictactoels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoels.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.multButton.setOnClickListener{
            val intent = Intent(this, MultiplayerActivity::class.java)
            startActivity(intent)
        }
        binding.sngButton.setOnClickListener{
            val intent = Intent(this, SingleplayerActivity::class.java)
            startActivity(intent)
        }


    }
}