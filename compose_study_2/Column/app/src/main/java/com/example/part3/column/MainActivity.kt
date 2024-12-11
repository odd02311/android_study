package com.example.part3.column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.column.ui.theme.ColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnTheme {
                ColumnEx()
            }
        }
    }
}

@Composable
fun ColumnEx() {
//    Column(modifier = Modifier.size(100.dp)) {
//        Text(text = "첫 번째")
//        Text(text = "두 번째")
//        Text(text = "세 번째")
//    }

    // 1. horizontalAlignment를 Column에 적용
//    Column(
//        horizontalAlignment = Alignment.End,
//        modifier = Modifier.size(100.dp)
//    ) {
//        Text(text = "첫 번째")
//        Text(text = "두 번째")
//        Text(text = "세 번째")
//    }


    // 2. Column에 verticalArrangement를 지정
    // SpaceAround, SpaceEvenly, SpaceBetween 지정
//
//    Column(
//        horizontalAlignment = Alignment.End,
//        verticalArrangement = Arrangement.Bottom,
//        modifier = Modifier.size(100.dp)
//    ) {
//        Text(text = "첫 번째")
//        Text(text = "두 번째")
//        Text(text = "세 번째")
//    }

    // 3. Text에 Modifier.align을 사용

    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "두 번째")
        Text(
            text = "세 번째",
            modifier = Modifier.align(Alignment.Start)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColumnTheme {
        ColumnEx()
    }
}