package com.example.part3.chaint_barrier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.part3.chaint_barrier.ui.theme.Chaint_barrierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chaint_barrierTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutEx(){
    ConstraintLayout(Modifier.fillMaxSize()){
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox){
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox){
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox){
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )
        
        // 1. `createVerticalChain`, `createHorizontalChain`을 이용, 3 박스의 리퍼런스를 연결
//        createVerticalChain(redBox, yellowBox, magentaBox) // 세로로 사슬이 연결되어 있다고 보면 된다.
//        createHorizontalChain(redBox, yellowBox, magentaBox)
        
        // 2. `createHorizontalChain`을 사용 `chainStyle` 키워드 파라미터 추가.
        // `ChainStyle.Packed`, `ChainStyle.Spread`, `ChainStyle.SpreadInside`등을 지정
        createHorizontalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)

        // 3. 3 박스의 top을 parent.top에 연결, 각각 다른 마진을 준다.

        // 4. `createBottomBarrer`로 베리어를 만든다. 이는 모든 박스들의 하단을 포함하는 베리어이다.
        val barrier = createBottomBarrier(redBox, yellowBox, magentaBox)
        
        // 5. `Text` 하나 만들고 top을 박스 베리어로 지정
        Text(
            text = "가나다라마 바사아 자차카타 파하 가나다라마 바사아 자차카타 파하 가나다라마 바사아 자차카타 파하 가나다라마 바사아 자차카타 파하 가나다라마 바사아 자차카타 파하",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrier)
            }
        )
        
        // 6. 체이닝 방향이나 베리어 방향을 바꾸어 보며 다양하게 테스트

    }
 }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chaint_barrierTheme {
        ConstraintLayoutEx()
    }
}