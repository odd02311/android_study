package com.example.part3.dropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.part3.dropdownmenu.ui.theme.DropdownmenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropdownmenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropDownMenuEx()
                }
            }
        }
    }
}

@Composable
fun DropDownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터: $counter")
    }

    // 1. `DropdownMenu`를 만들고 `expanded`를 `expandDropDownMenu`로 등록
    // `onDismissRequest`에 대해서는 `expandDropDownMenu`를 `false`로 바꾼다.
    DropdownMenu(
        expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        DropdownMenuItem(
            text = { Text("증가") }, // Text를 람다로 전달
            onClick = {
                counter++
            }
        )
        DropdownMenuItem(
            text = { Text("감소") }, // Text를 람다로 전달
            onClick = {
                counter--
            })
    }


    // 2. 두개의 `DropdownMenuItem`을 등록. `onClick`을 구현, 내용물은 `Text`로

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DropdownmenuTheme {
        DropDownMenuEx()
    }
}