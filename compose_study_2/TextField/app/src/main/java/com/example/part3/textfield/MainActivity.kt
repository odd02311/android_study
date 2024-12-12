package com.example.part3.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.textfield.ui.theme.TextfieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextfieldTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {
        // 1. TextField를 Text위에 만듬
        // value와 onValueChanged는 비움
//        TextField(value = "Tom", onValueChange = {})

        // 2. Text에 Android 대신 TextField 입력을 출력. mutableStateOf("") 필드를 하나 만든다.
//        TextField(
//            value = name,
//            onValueChange = { name = it}
//        )

        // 3. TextField에 label을 추가. 내용에는 `Text("Name")`을 채운다.
//        TextField(
//            value = name,
//            label = {
//                Text("이름")
//            },
//            onValueChange = { name = it}
//        )

        // 4. TextField와 Text 사이에 Spacer를 넣어 8.dp 간격을 준다
//        TextField(
//            value = name,
//            label = {
//                Text("이름")
//            },
//            onValueChange = { name = it}
//        )
//        Spacer(modifier = Modifier.size(8.dp))

        // 5. TexxtField를 OutlinedTextField로 변경

        OutlinedTextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = { name = it}
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Hello $name")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextfieldTheme {
        Greeting()
    }
}