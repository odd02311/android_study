package com.example.part3.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.surface.ui.theme.SurfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceTheme {
                // A surface container using the 'background' color from the theme
                    Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
//    Surface(
//        modifier = Modifier.padding(5.dp)
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 1. Surface에 elevation을 설정
    // 높이 설정 (그림자가 생긴다.)
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 2. border의 값을 설정
//    Surface(
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }
    
    // 3. Surface의 shape 설정
//    Surface(
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 10.dp,
//        shape = CircleShape
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 4. color를 지정
    // MaterialTheme.colorScheme에서 primary, error, background, surface, secondary를 차례로 지정
    // contentColor가 자동으로 선택된다.
    Surface(
        border = BorderStroke(width = 2.dp, color = Color.Gray),
        modifier = Modifier.padding(5.dp),
        shadowElevation = 10.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.error

    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp),
            color = Color.Black
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SurfaceTheme {
        Greeting("Android")
    }
}