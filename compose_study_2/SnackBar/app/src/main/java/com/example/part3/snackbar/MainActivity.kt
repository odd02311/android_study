package com.example.part3.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.part3.snackbar.ui.theme.SnackbarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SnackbarEx()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SnackbarEx() {
    var counter by remember { mutableStateOf(0) }

    // 3. couroutineScope를 만들고 `remeberCoroutineScope`를 사용
    val coroutineScope = rememberCoroutineScope()
    
    // 1. scaffoldState를 만들고 Scaffold에 설정.
    // scaffoldState를 만들기 위해 `rememberScaffoldState`를 사용
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }
    ){
        // 2. "더하기" 버튼을 만들고, action에서 counter를 증가
        Button(onClick = {
            counter++
            coroutineScope.launch {
            val result = scaffoldState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
//                when (result) {
//                    SnackbarResult.Dismissed -> {}
//                    SnackbarResult.ActionPerformed -> {}
//                }
            }
        }){
            Text("더하기")
        }
        // 4. 버튼의 onClick에서 `coroutineScope.launch`를 사용

        // 5. 스낵바를 사용하기 위해 `scaffoldState.snackbarGostState.showSnackbar` 사용
        
        // `message`에 카운터 출력
        // `actionLabel`를 "닫기"로 지정
        // `duration`에 `SnackbarDuration.Short`를 사용
        

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnackbarTheme {
        SnackbarEx()
    }
}