package com.example.part3.bottomappbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.part3.bottomappbar.ui.theme.BottomappbarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomappbarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomAppBarEx()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomAppBarEx(){
    val scaffoldState = remember { SnackbarHostState() } // remember가 붙어있으면 remember 함수를 호출하는 유틸리티다.
    val coroutineScope = rememberCoroutineScope()
    var counter by remember {
        mutableStateOf(0)
    }
    
    // 1. `Scaffold`에 `scaffoldState`를 설정
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
        bottomBar =
        {
            BottomAppBar{
                Text("Hi!")
                Button(
                    onClick = {
                        coroutineScope.launch { // launch를 쓰는 이유는 showSnackbar가 suspend function이기 때문이다. suspend fun은 코루틴안에서 호출할 수 있다.
                            scaffoldState.showSnackbar("안녕하세요") // 코루틴을 쓰는 이유는 자동으로 사라지게 하기 위해서 쓰는것
                        }
                }
                ) {
                    Text("인사하기")
                }
                Button(
                    onClick = {
                        counter++
                        coroutineScope.launch {
                            scaffoldState.showSnackbar("${counter}입니다.")
                        }
                }
                ){
                    Text("더하기")
                }
                Button(
                    onClick = {
                        counter--
                        coroutineScope.launch {
                            scaffoldState.showSnackbar("${counter}입니다.")
                        }
                }
                ){
                    Text("빼기")
                }
            }

        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "카운터는 ${counter}회입니다.",
                modifier = Modifier.align(Alignment.Center)
            )
        }
//        LaunchedEffect(scaffoldState) {
//            coroutineScope.launch {
//                scaffoldState.showSnackbar("안녕하세요")
//            }
//        }
    }

    // 2. `bottomBar` 파라미터에 `BottomAppBar`를 넣고, 내용은 텍스트와 버튼을 넣는다.
    // 버튼에는 `snackBar`를 연동해 메시지를 출력
    
    // 3. 더하기, 빼기 버튼을 추가로 만들고 `MutableState` 생성
    // `Scaffold`의 `content`에 `Text`를 넣어 카운터를 출력
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomappbarTheme {
        BottomAppBarEx()
    }
}