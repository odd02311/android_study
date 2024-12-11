package com.example.part3.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                BoxEx()
            }
        }
    }
}

@Composable
fun BoxEx() {
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello World",
//            modifier = Modifier.align(Alignment.Center),
//        )
//    }

    // 1. Text 2개를 Box안에 배치
    // 여러 요소를 넣을수 있고 겹쳐서 배치도 가능하다.
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(
//            text = "Hello World",
//            modifier = Modifier.align(Alignment.BottomEnd),
//        )
//        Text(
//            text = "Jetpack",
//            modifier = Modifier.align(Alignment.CenterEnd),
//        )
//        Text(
//            text = "Compose",
//            modifier = Modifier.align(Alignment.TopStart),
//        )
//    }



    // 2. 2개의 Box를 Box안에 배치 사이즈를 70dp, 색상을 각기 다르게 적용

//    Box(modifier = Modifier.size(100.dp)) {
//      Box(modifier = Modifier.size(70.dp).background(color = Color.Cyan).align(Alignment.Center))
//      Box(modifier = Modifier.size(70.dp).background(color = Color.Yellow).align(Alignment.BottomEnd))
//    }

    // 3. 부모 Box에 modifier 설정을 제거해서 컨텐츠 사이즈만큼 보이게 설정
    // 첫번째 자식 Box의 사이즈를 matchParentSize()로 설정
    // fillMaxSize()로 설정

    Box {
        Box(modifier = Modifier.fillMaxSize().background(color = Color.Cyan).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(70.dp).background(color = Color.Yellow).align(Alignment.Center))
    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxTheme {
        BoxEx()
    }
}