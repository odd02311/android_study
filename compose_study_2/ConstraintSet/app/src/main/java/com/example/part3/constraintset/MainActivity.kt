package com.example.part3.constraintset

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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.part3.constraintset.ui.theme.ConstraintSetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintSetTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintSetEX()
                }
            }
        }
    }
}

@Composable
fun ConstraintSetEX(){
    val constraintSet = ConstraintSet {
        // 1. createRefFor로 레드, 마젠타, 그린, 옐로 박스를 위한 레퍼런스 만든다.
        // 파라미터 id로 레퍼런스의 이름을 적어 준다. ex): redBox
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        // 2. `constrain`을 열고 만들었던 레퍼런스를 인자로 넣는다.
        // 레드, 마젠타, 그린, 옐로 박스 레퍼런스에 대해 `constrain`을 적고 후행 람다의 내용은 기존에 `constrainAs`에 적어둔 것을 참고
        constrain(redBox) {
            bottom.linkTo( parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(magentaBox) {
            start.linkTo( parent.start, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }
        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }

    }
    
    // 5. ConstraintLayout의 첫 인자로 ConstraintSet을 전달
    ConstraintLayout (
        constraintSet,
        modifier = Modifier.fillMaxSize()
    ){  
        // 3. `ConstraintLayout`내에서 생성한 레퍼런스와 `constraintAs` modifier 삭제
//        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        // 4. Box마다 `layoutId`를 설정한다. 파라미터는 `ConstraintSet`에 만든 레퍼런스의 id로 적는다.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
//                .constrainAs(redBox){
////                    bottom.linkTo( parent.bottom, 10.dp)
////                    end.linkTo(parent.end, 30.dp)
//                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
//                .constrainAs(magentaBox){
////                    start.linkTo( parent.start, 10.dp)
////                    end.linkTo(parent.end, 30.dp)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
//                .constrainAs(greenBox){
////                    centerTo(parent)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
//                .constrainAs(yellowBox){
////                    start.linkTo(greenBox.end)
////                    top.linkTo(greenBox.bottom)
//                }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintSetTheme {
        ConstraintSetEX()
    }
}