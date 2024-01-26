package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab1.databinding.ActivityInstructionsBinding

class InstructionsActivity : AppCompatActivity(), ICommunicator {

    //declare binding variable
    private lateinit var binding: ActivityInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate the activity and set the contentView to the root of the xml
        binding = ActivityInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add fragment
        addFragment()

        //switch activity to first screen
        binding.backBtn.setOnClickListener{
            switchActivity()
        }
    }

    //function to add fragments to activity
    private fun addFragment() {
        val detailsFragment = DetailsFragment()
        val levelsFragment = LevelsFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.detailFragment, detailsFragment)
        transaction.add(R.id.levelFragment, levelsFragment)
        transaction.commit()
    }

    //Switch screen back
    private fun switchActivity(){
        finish()
    }

    override fun passLevelsInfo(levelName: String){

        val detailsFragment = supportFragmentManager.findFragmentById(R.id.detailFragment) as? DetailsFragment
        detailsFragment?.change(levelName)
    }
}