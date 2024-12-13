package com.example.part3.scaffold

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ScaffoldEx()
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ){
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() },
        )
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldEx(){
    var checked by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        // 1. `topBar`를 `TopAppBar로 채우기
        TopAppBar(
            navigationIcon = {
                IconButton( onClick = { } ){
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "뒤로 가기"
                    )
                }
            },
            title = {
                Text(text = "Scaffold App")
            },
            actions = {

            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.White
            )
        )

    },
        floatingActionButton = {
            FloatingActionButton(onClick = { }){

            }
        }
    ) { innerPadding ->
            Surface( modifier = Modifier
                    .padding(innerPadding) // innerPadding을 여기서 적용
                    .padding(8.dp)
                ){
                    // 2. 아래 CheckBoxWithContent를 넣기
                    CheckBoxWithContent(
                        checked = checked,
                        toggleState = { checked = !checked }
                    ){
                        Text(text = "Like compose")
                    }

                }
    }
}

@Preview(showBackground = true)
@Composable
fun DegaultPreview() {
    ScaffoldTheme {
        ScaffoldEx()
    }
}