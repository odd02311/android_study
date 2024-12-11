package com.example.part3.compose_2

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.compose_2.ui.theme.Compose_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_2Theme {
                // A surface container using the 'background' color from the theme
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this, "Send clicked", Toast.LENGTH_SHORT).show()
                })
                }
            }
        }
    }


@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
//    Button(onClick = onButtonClicked){
//        Text(text = "Send")
//    }

    // 1, Button 클릭 시 Toast를 출력
//    ButtonExample(onButtonClicked = {
//        Toast.makeText(this, "Send clicked", Toast.LENGTH_SHORT).show()
//    })

    // 2. Icon을 Text 앞에 추가
    // imageVector에는 Icons.Filled.send 넣기
    // contentDescription에는 null 널기
    // 버튼안 아이콘 설정
//    Button(onClick = onButtonClicked){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
//        )
//        Text(text = "Send")
//    }

    // 3. 아이콘 과 텍스트 사이에 spacer를 넣기
    // modifier에 Modifier.size를  넣고 지정
    // ButtonDefaults.IconSpaccing 지정 설정
    // 버튼 안에 아이콘과 텍스트 간격

//    Button(onClick = onButtonClicked){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 4. enabled를 false로 지정
    // 버튼 비활성화

    Button(
        onClick = onButtonClicked,
        enabled = false
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }

    // 5. border에 BorderStroke를 설정
    // 버튼 안 또 다른 속성값 적용

//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta)
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 6. shape를 CircleShape로 지정
    // 버튼의 모서리 지정, roundedCornerShape는 border의 속성도 같이 적용됨

//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta),
//        shape = CircleShape
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 7. contentPadding에 PaddingValues를 설정
    Button(
        onClick = onButtonClicked,
        border = BorderStroke(10.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_2Theme {
        ButtonExample(onButtonClicked = {})
    }
}