package com.example.part3.compose_2

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Button(onClick = onButtonClicked){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null // Text에 이미 send라고 적어놓았기 때문에 null
        )
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