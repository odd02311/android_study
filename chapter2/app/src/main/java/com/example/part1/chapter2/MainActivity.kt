package com.example.part1.chapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 화면 요소 가져오기
        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val plusButton = findViewById<Button>(R.id.plusButton)

        // numberText 에 표현할 숫자 변수
        var number = 0

        // 클릭 체킹
        // setOnClickListener = 클릭을 했을때 액션
        resetButton.setOnClickListener {
            // number 리셋
            number = 0
            // number text 출력
            numberTextView.text = number.toString()
            // 확인용 로그
            Log.d("onclick", "리셋 되었습니다. 숫자는 $number 입니다.")
        }

        plusButton.setOnClickListener {
            number += 1
            numberTextView.text = number.toString()
            Log.i("onclick", "+1 되었습니다. 숫자는 $number 입니다.")
        }
    }
}