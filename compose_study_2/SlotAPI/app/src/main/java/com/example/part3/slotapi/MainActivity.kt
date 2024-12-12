package com.example.part3.slotapi

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
import com.example.part3.slotapi.ui.theme.SlotapiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotapiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                   SlotEx()
                }
            }
        }
    }
}

// 1. `Row`를 `@Composable` 함수로 분리 한다. `checked`의 값, `Text`의 `text`를 인자로 전달한다.
//@Composable
//fun CheckboxWithText(checked: MutableState<Boolean>, text: String) {
//    Row(verticalAlignment = Alignment.CenterVertically){
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//    }
//}

// 2. `@Composable` 함수에서 `@Composable () -> Unit` 타입으로 `content`를 받아온다.
// `Row`에 `Modifier.clickable`를 넣어 전체를 클릭 가능하게 한다.
//@Composable
//fun CheckboxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable () -> Unit
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}

// 3. `content`의 타입을 `@Composable RowScope.() -> Unit`로 바꾼다.
// 이렇게 다른 콤포저블 컨텐트를 넣는 방식을 Slot API라고 한다.
//@Composable
//fun CheckboxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable RowScope.() -> Unit
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}


// 4. 상태를 바꾸는 람다를 `@Composable` 함수의 인자로 뺀다. 인자에서 MutableState대신 boolean 값으로 변경
@Composable
fun CheckboxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(WindowInsets.safeContent.asPaddingValues())
    ) {

//        Row(verticalAlignment = Alignment.CenterVertically){
//            Checkbox(
//                checked = checked1.value,
//                onCheckedChange = { checked1.value = it }
//            )
//            Text(
//                text = "텍스트 1",
//                modifier = Modifier.clickable { checked1.value = !checked1.value }
//            )
//        }


//        Row(verticalAlignment = Alignment.CenterVertically){
//            Checkbox(
//                checked = checked2.value,
//                onCheckedChange = { checked2.value = it }
//            )
//            Text(
//                text = "텍스트 2",
//                modifier = Modifier.clickable { checked2.value = !checked2.value }
//            )
//        }

//        CheckboxWithSlot(checked1) {
//            Text("텍스트 1")
//        }
//        CheckboxWithSlot(checked2) {
//            Text("텍스트 2")
//        }

        CheckboxWithSlot(checked = checked1,
            onCheckedChanged = {checked1 = !checked1}
        ) {
            Text("텍스트 1")
        }
        CheckboxWithSlot(checked = checked2,
            onCheckedChanged = {checked2 = !checked2}
            ) {
            Text("텍스트 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotapiTheme {
        SlotEx()
    }
}