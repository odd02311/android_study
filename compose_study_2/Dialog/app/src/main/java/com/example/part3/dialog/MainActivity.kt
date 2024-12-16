package com.example.part3.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.part3.dialog.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = !openDialog }) {
            Text("다이로그 열기")
        }
        Text("카운터: $counter")
    }

    if(openDialog){
        AlertDialog(onDismissRequest = {
            // 1. `openDialog`를 이용, 다이로그를 끌 수 있게 한다.
            openDialog = false
        }, confirmButton = {
            // 2. "더하기" 버튼 생성, `counter` 증가, 다이로그 끄기
            Button(onClick = {
                counter++
                openDialog = false
            }){
                Text("더하기")
            }
        }, dismissButton = {
            // 3. "취소" 버튼 생성, 다이로그 끄기
            Button(onClick = {
                openDialog = false
            }){
                Text("취소")
            }
        }, title = {
            // 4. 타이틀 생성, "더하기"
            Text("더하기")
        }, text = {
            // 5. 다이로그에서 설명할 문구 출력
            Text("더하기 버튼을 누르면 카운터를 증가합니다. \n버튼을 눌러주세요")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogTheme {
        DialogEx()
    }
}