package com.example.part3.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.row.ui.theme.RowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowTheme {
                RowEx()
            }
        }
    }
}

@Composable
fun RowEx() {
//    Row(modifier = Modifier.height(40.dp)) {
//        Text(text = "첫번째!")
//        Text(text = "두번째!")
//        Text(text = "세번째!")
//    }

    // 1. 각 Text의 Modifier에 Align을 설정
    // Alignment.Top, CenterVertically, Bottom 지정
//    Row(modifier = Modifier.height(40.dp)) {
//        Text(text = "첫번째!", modifier = Modifier.align(Alignment.Top))
//        Text(text = "두번째!", modifier = Modifier.align(Alignment.CenterVertically))
//        Text(text = "세번째!", modifier = Modifier.align(Alignment.Bottom))
//    }


    // 2. Row에 verticalAlignment를 설정
    // Text에 align을 사용할 때와 쓰이는 값이 같다.
//    Row(
//        verticalAlignment = Alignment.Bottom,
//        modifier = Modifier.height(40.dp)
//    ) {
//        Text(text = "첫번째!", modifier = Modifier.align(Alignment.Top))
//        Text(text = "두번째!")
//        Text(text = "세번째!")
//    }


    // 3. Row의 width를 200dp 정도로 설정
    // Row에 horizontalArrangement에 Arrangement.Center를 설정
    // Start, End, SpaceAround, SpaceBetween, SpaceEvenly 설정

//    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.Bottom,
//        modifier = Modifier
//            .height(40.dp)
//            .width(200.dp)
//    ) {
//        Text(text = "첫번째!", modifier = Modifier.align(Alignment.Top))
//        Text(text = "두번째!")
//        Text(text = "세번째!")
//    }


    // 4. horizontalArrangement를 제거 각 Text에 Modifier.weight를 설정.
    // 각 항목의 weight 값 바꾸기
    // 비중을 통해 위치 나누기
//    Row(
//        verticalAlignment = Alignment.Bottom,
//        modifier = Modifier
//            .height(40.dp)
//            .width(200.dp)
//    ) {
//        Text(
//            text = "첫번째!",
//            modifier = Modifier.align(Alignment.Top)
//                .weight(3f)
//        )
//        Text(
//            text = "두번째!",
//            modifier = Modifier.weight(1f)
//        )
//        Text(
//            text = "세번째!",
//            modifier = Modifier.weight(3f)
//        )
//    }

    // 5. Text 대신 Icon을 넣기
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ) {
        Text(
            text = "첫번째!",
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.Top)
                .weight(3f)
                .background(Color.Magenta)
        )
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "추가",
            modifier = Modifier.weight(1f)
                .background(Color.Cyan)
        )

        Text(
            text = "세번째!",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(3f)
                .background(Color.Blue)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowTheme {
        RowEx()
    }
}