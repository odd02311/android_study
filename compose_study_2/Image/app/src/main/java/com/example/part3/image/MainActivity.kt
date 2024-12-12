package com.example.part3.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.part3.image.ui.theme.ImageTheme
import com.example.part3.surface.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                    Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
   Column{
       // 1. Image 만들기. painter 항목에서 painterResourcce(id = R.drawable.wall)
       // contentDescription에 엔텔로프 캐년
       Image(
           painter = painterResource(id = R.drawable.wall),
           contentDescription = "엔텔로프 캐년"
       )
       
       // Image
       
       // 2 두 번째 Image 만들기
       // imageVector에 Icons.filled.Settings를 설정
       Image(
           imageVector = Icons.Filled.Settings,
           contentDescription = "설정 아이콘"
       )
       // image
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageTheme {
        Greeting()
    }
}