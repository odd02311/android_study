package com.example.part1.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.part1.chapter3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditText = binding.inputEditText
        val inputUnitTextView = binding.inputUnitText
        val swapImageButton = binding.swapImageButton

        var inputNumber : Int = 0
        var cmToM = true

        inputEditText.addTextChangedListener{ text ->
                inputNumber = if(text.isNullOrEmpty()){
                    0
                } else {
                    text.toString().toInt()
                }
            
            // 자동 단위 변환 식
            if(cmToM){
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
        
        // 버튼을 눌러서 단위 변환 식
        swapImageButton.setOnClickListener {
            cmToM = cmToM.not()
            if(cmToM){
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }
}