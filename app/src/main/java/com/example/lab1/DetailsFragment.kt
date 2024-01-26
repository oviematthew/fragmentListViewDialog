package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab1.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun change(levelName: String?) {
        when (levelName) {
            "Level 1" -> binding.levelValue.text = "Level 1 \n Immediate Gratification: Pleasure and minimize pain"
            "Level 2" -> binding.levelValue.text = "Level 2 \n Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage"
            "Level 3" -> binding.levelValue.text = "Level 3 \n Contributive: Do good beyond self, Make an optimal positive difference for others"
            "Level 4" -> binding.levelValue.text = "Level 4 \n Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love."
            else -> binding.levelValue.text = levelName
        }
    }
}