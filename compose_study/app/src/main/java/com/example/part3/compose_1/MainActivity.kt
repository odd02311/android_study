package com.example.part3.compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.part3.compose_1.ui.theme.Compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    // 1. 색상을 지정하기 위해 color 파라미터에 Color.Red를 전달
//    Text(color = Color.Red, text = "안녕하세요 + $name")

    // 2. Color 객체를 이용, 해쉬값으로 색상 전달
//    Text(color = Color(0xffff9944), text = "안녕하세요 + $name")

    // 3. fontSize 파라미터에 30.sp를 전달
//    Text(color = Color(0xffff9944), text = "안녕하세요 + $name", fontSize = 30.sp)

    // 4. fontWeight에 FontWeight.Bold 전달
//    Text(color = Color.Red, text = "안녕하세요 + $name", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    // 5. fontFamily에 FontFamily.Cursive를 전달
//    Text(
//        color = Color.Red,
//        text = "Hello + $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//    )

    // 6. letterSpacing에 2.sp를 지정
//    Text(
//        color = Color.Red,
//        text = "Hello  $name",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

    // 7. maxLines를 2로 지정 문자열 추가
    Text(
        color = Color.Red,
        text = "Hello  $name\nHello $name\nHello $name",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        maxLines = 2,
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_1Theme {
        Greeting("Android")
    }
}