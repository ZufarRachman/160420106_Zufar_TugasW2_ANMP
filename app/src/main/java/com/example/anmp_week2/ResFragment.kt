package com.example.anmp_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class ResFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_res, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val correctResult = ResFragmentArgs.fromBundle((requireArguments())).correctAnswer
        val txtRes = view.findViewById<TextView>(R.id.txtScore)
        txtRes.text = "Your Score is '$correctResult'"

        btnBack.setOnClickListener {
            val actionBack = ResFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(actionBack)
        }
    }
}