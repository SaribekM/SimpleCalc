package com.example.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.simplecalc.viewModel.CalcViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val VM = CalcViewModel()

    private lateinit var textViewPrimary: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewPrimary = findViewById(R.id.textViewPrimary)
    }

    override fun onClick(v: View?) {
        val pressedBtnTag = v?.tag

        VM.currentText = textViewPrimary.text as String
        VM.currentButton = (v as TextView).text as String

        when (pressedBtnTag) {

            "NUMBER" -> {
                textViewPrimary.text = VM.getNumber()
            }
            "OPERATION" -> {
                textViewPrimary.text = VM.getOperationResult()
            }
            "EQUAL" -> {
                textViewPrimary.text = VM.getCalculationResult()
            }
            else -> textViewPrimary.text = VM.resetAll()
        }
    }
}