package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment


class LevelsFragment : ListFragment() {

    var levels = arrayOf(
        "Level 1",
        "Level 2",
        "Level 3",
        "Level 4"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_levels, container, false)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, levels
        )
        listAdapter = adapter
        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        Log.d("LevelsFragment", "position $position month: ${levels[position]}")

        (activity as? ICommunicator)?.passLevelsInfo(levels[position])

        // selected item color
        listView.setSelector(android.R.color.black)

    }

}