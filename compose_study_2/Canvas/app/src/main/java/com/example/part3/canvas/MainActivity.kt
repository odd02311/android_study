package com.example.part3.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CanvasEX()
                }
            }
        }
    }
}

@Composable
fun CanvasEX() {
    Canvas(modifier = Modifier.size(20.dp)) { // 캔버스는 무조건 modifier를 만들어 줘야 한다.

        // 1. `drawLine`을 사용. 파라미터로 색상, 시작(`Offset`) 끝(`Offset` 타입)을 받는다
        drawLine(Color.Red, Offset(30f, 10f), Offset(50f,40f))

        // 2. `drawCircle`을 사용. 색상, 반지름, 중앙(`Offset`)
        drawCircle(Color.Yellow, 10f, Offset(15f, 40f))
        drawRect(Color.Magenta, Offset(30f, 30f), Size(10f, 10f))


        // 3. 아래의 규칙으로 그려진 아이콘 `Icons.Filled.Send`를 `drawLine`으로 변경
        
        // 4. ImageVector에서는 한붓 그리기 처럼 연속으로 그려진다. `moveTo`로 2.01f, 21.0f로 이동한 후 거기에서
        // 23.0f, 12.0f로 선이 그어지는 식

        // moveTo(2.01f, 21.0f)
        // lineTo(23.0f, 12.0f)
        // lineTo(2.01f, 3.0f)
        // lineTo(2.0f, 10.0f)
        // lineToRelative(15.0f, 2.0f)
        // lineToRelative(-15.0f, 2.0f)
        // close
        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.0f, 12.0f), Offset(2.0f, 3.0f))
        drawLine(Color.Green, Offset(2.0f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.0f, 21.0f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanvasTheme {
        CanvasEX()
    }
}