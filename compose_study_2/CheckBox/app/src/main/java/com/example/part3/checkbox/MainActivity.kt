package com.example.part3.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.checkbox.ui.theme.CheckboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckboxTheme {
             CheckBoxEx()
            }
        }
    }
}



@Composable
fun CheckBoxEx() {
    Row(verticalAlignment = Alignment.CenterVertically){
        // 1. Checkbox 만들기. Checked 속성은 false, onCheckedChange는 비워두기
//        Checkbox(checked = false, onCheckedChange = {})


        
        // 2. onCheckedChange에서 Boolean 값 변수를 바꾸고, checked에서 그 값을 반영
//        var checked = false
//
//
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
        // destruction - 비구조화, 반구조화, 구조분해
        // val (a, b) = listOf(2, 3)

        // 3. boolean 대신 remember { mutableStateOf(false) }를 사용하여 상태를 도입
        // value 프로퍼티를 이용해야 함
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.size(200.dp)
//        ) {
//            Text(text = "프로그래머입니까?")
//
//            var checked = remember { mutableStateOf(false) }
//            Checkbox(
//                checked = checked.value,
//                onCheckedChange = {
//                    checked.value = !checked.value
//                }
//            )
//
//        }

        // 위임된 속성
        // var checked by remember { mutableStateOf(false) }
        // checked가 프로퍼티인 것 처럼
        // 4. delegated properties로 변경

//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.size(200.dp)
//        ) {
//            Text(text = "프로그래머입니까?")
//
//            var checked by remember { mutableStateOf(false) }
//            Checkbox(
//                checked = checked,
//                onCheckedChange = {
//                    checked = !checked
//                }
//            )
//        }

        // 구조분해
        // 5. destruction으로 상태를 받아서 사용
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.size(200.dp)
        ) {
            val (getter, setter) = remember { mutableStateOf(false) }
            Checkbox(
                checked = getter,
                onCheckedChange = setter
            )

            Text(
                text = "프로그래머입니까?",
                modifier = Modifier.clickable {
                    setter(!getter)
                }
            )
        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckboxTheme {
        CheckBoxEx()
    }
}