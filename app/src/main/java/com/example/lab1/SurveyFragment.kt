package com.example.lab1

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class SurveyFragment : DialogFragment() {

    private var sendMessages: SendMessages? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_survey, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setTitle(R.string.choice)
            .setSingleChoiceItems(levels, checkedItem, DialogInterface.OnClickListener {
                    dialog, which ->
                sendMessages!!.choiceMade(which)
            })
            .setPositiveButton(R.string.ok, DialogInterface.OnClickListener {
                    dialog, which -> Log.d("confirmation dialog", "positive button")
            })
            .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    dialog, which -> Log.d("confirmation dialog", "negative button")
            }).create()

    }

    companion object {

        var levels = arrayOf( "Level 1", "Level 2", "Level 3", "Level 4")

        //select nothing first
        var checkedItem = -1

        @JvmStatic
        open fun newInstance(title: Int):
                SurveyFragment? {
            val fragment = SurveyFragment()
            val args = Bundle()
            args.putInt("title", title)
            fragment.arguments =args
            return fragment
        }
    }

    // attach the interface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // send information through interface
        sendMessages = context as SendMessages
    }

    // Interface to send information from the fragment to MainActivity
    internal interface SendMessages {
        fun choiceMade(msg:Int?)
    }
}