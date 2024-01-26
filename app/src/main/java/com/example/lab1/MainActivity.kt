package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SurveyFragment.SendMessages {

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

        //popup dialog on click of survey button
        binding.surveyBtn.setOnClickListener{
            val surveyFrag: DialogFragment? = SurveyFragment
                .newInstance(R.string.confirm)
            surveyFrag!!.show(supportFragmentManager, "dialog")
        }
    }

    //Switch screen
    private fun switchActivity(){
        val intent = Intent(this, InstructionsActivity::class.java)
        startActivity(intent)
    }


    override fun choiceMade(msg: Int?)
    {
        binding.surveyTextView.text = "My choice is: ${SurveyFragment.levels[msg!!]}"
        SurveyFragment.checkedItem = msg
    }
}