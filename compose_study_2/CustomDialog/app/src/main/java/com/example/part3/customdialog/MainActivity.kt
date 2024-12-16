package com.example.part3.customdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.part3.customdialog.ui.theme.CustomdialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomdialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomDialog()
                }
            }
        }
    }
}

@Composable
fun CustomDialog() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }){
            Text("다이로그 열기")
        }
        Text("카운터: $counter")
    }

    if(openDialog){
        Dialog(onDismissRequest = {
            // 1. Dismiss 처리를 한다.
            openDialog = false
        }) {
            Surface {
                // 2. 컬럼을 만들고 설명을 적는다.
                Column(modifier = Modifier.padding(8.dp)){
                    Text("버튼을 클릭해주세요. \n * +1을 누르면 값이 증가됩니다.\n * -1을 누르면 값이 감소합니다.")
                    Row(modifier = Modifier.align(Alignment.End)){
                        Button(onClick = {
                            openDialog = false
                        }){
                            Text("취소")
                        }

                        Button(onClick = {
                            openDialog = false
                            counter++
                        }){
                            Text("+1")
                        }

                        Button(onClick = {
                            openDialog = false
                            counter--
                        }){
                            Text("-1")
                        }
                    }
                }
                // 3. 컬럼 안에 로우를 만들어 수평 방향으로 버튼을 배열한다.
                // 버튼은 +1, -1, 취소로 구성한다.

                // +1은 counter를 증가시키고 -1은 감소, 취소는 다이로그를 닫는다.
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomdialogTheme {
       CustomDialog()
    }
}