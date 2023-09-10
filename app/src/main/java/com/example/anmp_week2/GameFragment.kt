package com.example.anmp_week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class GameFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var correctAnsw = 0
        val txtNumb1 = view.findViewById<TextView>(R.id.txtNum1)
        val txtNumb2 = view.findViewById<TextView>(R.id.txtNum2)

        val random1 = (0..50).shuffled().last().toString()
        val random2 = (0..50).shuffled().last().toString()

        txtNumb1.text = random1.toString()
        txtNumb2.text = random2.toString()

        val txtAnswer = view.findViewById<TextView>(R.id.txtAnswer)
        var res = txtNumb1.text.toString().toInt() + txtNumb2.text.toString().toInt()

        val btnAnswer = view.findViewById<Button>(R.id.btnRes)

        btnAnswer.setOnClickListener {
            if (txtAnswer.text.toString() == res.toString()){

                correctAnsw += 1

                txtNumb1.text = (0..50).shuffled().last().toString()
                txtNumb2.text = (0..50).shuffled().last().toString()

                res = txtNumb1.text.toString().toInt() + txtNumb2.text.toString().toInt()
                txtAnswer.text = ""
            }
            else {
                val actionRes = GameFragmentDirections.actionResultFragment(correctAnsw)
                Navigation.findNavController(it).navigate(actionRes)

            }
        }

        if (arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName


            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text = "$playerName's turn"
        }

//        val btnBack = view.findViewById<Button>(R.id.btnRes)
//        btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
        }
    }
