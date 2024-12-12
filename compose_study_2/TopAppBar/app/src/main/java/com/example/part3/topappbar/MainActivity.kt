package com.example.part3.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.part3.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBarEx("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarEx(name: String) {
    Column {
        // 1. TopAppBar를 만들고 title 항목을 넣는다.
//        TopAppBar(
//            modifier = Modifier
//                .height(30.dp)
//                .width(200.dp),
//
//            title = {
//                Text(
//                    text ="TopAppBar",
//                    style = TextStyle(fontSize = 12.sp),
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Start
//                )},
//            colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = Color.Gray,
//                titleContentColor = Color.White
//            )
//        )

        // 2. navigationIcon 파라미터를 채운다. IconButton을 만들고 자식으로 Icon을 넣는다.
        // 아이콘은 Icons.Filled.ArrowBack을 채운다. onClick은 비워둔다.
//        TopAppBar(
//            modifier = Modifier
//                .height(40.dp)
//                .width(400.dp),
//
//            title = {
//                    Text(
//                        text = "TopAppBar",
//                        style = TextStyle(fontSize = 16.sp),
//                        )
//                    },
//
//            navigationIcon = {
//                IconButton(
//                    onClick = {},
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "업 네비게이션",
//                    )
//                }
//            },
//
//            colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = Color.Gray,
//                titleContentColor = Color.White
//            )
//        )


        // 3. actions를 추가. Icons.Filled의 여러 아이콘을 이용
        TopAppBar(
            title = {
                Text(
                    text = "TopAppBar",
                    style = TextStyle(fontSize = 16.sp),
                )
            },

            navigationIcon = {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션",
                    )
                }
            },

            actions = {
                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }

                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}){
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }

            },

            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.White
            )
        )



        // 4. TopAppBar content 파라미터 버전을 만든다.

        Text(text = "Hello $name!" )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBarTheme {
        TopBarEx("Android")
    }
}