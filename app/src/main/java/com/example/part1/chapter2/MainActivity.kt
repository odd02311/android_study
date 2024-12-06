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

        // 클릭 체킹
        // setOnClickListener = 클릭을 했을때 액션
        resetButton.setOnClickListener {
            // 확인용 로그
            Log.d("onclick", "리셋 버튼이 클릭 되었습니다.")
        }

        plusButton.setOnClickListener {
            Log.i("onclick", "플러스 버튼이 클릭 되었습니다.")
        }
    }
}