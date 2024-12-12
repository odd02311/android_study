package com.example.part3.boxwithconstraints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part3.boxwithconstraints.ui.theme.BoxWithConstraintsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    // 4. Column에 witdh 지정 제한
    Column(modifier = Modifier.width(150.dp)) {
        // 2. Inner의 인자로 Modifier.widthIn(min = 100.dp) 전달
        // heightIn 및 각각 인자의 max값도 전달
        Inner(modifier = Modifier
            .widthIn(200.dp)
            .heightIn(160.dp)
        )
        Inner(modifier = Modifier
            .widthIn(200.dp)
            .heightIn(160.dp)
        )

    }
}

// 1. Inner 인자로 modifier를 전달. 기본값을 modifier로 지정
// 파라미터로 받은 modifier를 BoxWithConstrains에 전달
@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // 3. maxHeight 값이 150dp가 넘을 때만 추가로 텍스트 출력
        if(maxHeight > 150.dp) {
            Text("꽤 깁니다!!",
            modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text("maxW: $maxWidth maxH:$maxHeight minW: $minWidth minH:$minHeight ")
    }
}


@Preview(showBackground = true)
@Composable
fun DefualtPreview() {
    BoxWithConstraintsTheme {
       Outer()
    }
}
