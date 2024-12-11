package com.example.part3.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                ModifierEx()

            }
        }
    }
}

@Composable
fun ModifierEx() {
//    Button(onClick = {}){
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 1. modifier에 Modifier.fillMaxSiz() 지정
    // 버튼이 화면 전체 적용
//    Button(
//        onClick = {},
//        modifier = Modifier.fillMaxSize(),
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 2. Modifier.height 설정
    // 세로 길이가 100dp로 설정됨

//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp),
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 3. width 설정
    // 가로 길이 200
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .height(100.dp)
//            .width(200.dp),
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 4. size에 width와 height를 인자로 넣기
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp, 200.dp)
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 5. background 설정 (버튼에서는 설정이 되지않음)
    // Button에 되지 않으니 Text나 Icon에 지정
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp)
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null,
//            modifier = Modifier.background(color = Color.Red)
//
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 6. colors 파라미터에 ButtonDefaults.buttonColors를 설정
    // containerColor와 contentColor 프로퍼티를 설정
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Magenta,
//            contentColor = Color.Cyan,
//
//        ),
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp, 200.dp)
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 7. Button의 modifier에 padding을 추가
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Magenta,
//            contentColor = Color.Cyan,
//
//            ),
//        onClick = {},
//        modifier = Modifier
//            .size(200.dp)
//            .padding(10.dp),
//    ){
//
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 8. Button에 enabled를 false로 설정, Text의 modifier에 clickable을 넣는다
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Magenta,
//            contentColor = Color.Cyan,
//
//            ),
//        onClick = {},
//        enabled = false,
//        modifier = Modifier
//            .size(200.dp)
//            .padding(10.dp),
//    ){
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            "Search",
//            modifier = Modifier.clickable {}
//        )
//    }

    // 9. Text의 modifier에 offset을 설정 x 파라미터를 설정
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.Cyan,
            ),
        onClick = {},
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp),
    ){
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
                .background(Color.Blue),

        )
        Text(
            "Search",
            modifier = Modifier
                .offset(y = 10.dp)
                .background(Color.Blue)
        )
    }



}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierTheme {
        ModifierEx()
    }
}