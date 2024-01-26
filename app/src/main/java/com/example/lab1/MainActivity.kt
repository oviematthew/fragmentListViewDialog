package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate the activity and set the contentView to the root of the xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //switch activity to instructions screen
        binding.instructionsBtn.setOnClickListener{
            switchActivity()
        }
    }

    //Switch screen
    private fun switchActivity(){
        val intent = Intent(this, InstructionsActivity::class.java)
        startActivity(intent)
    }



}