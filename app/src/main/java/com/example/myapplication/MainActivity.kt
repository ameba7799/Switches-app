package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    val items = mutableListOf("test", "Test", "TEST")
    val itemsList = (0..5).toList()
    val itemsIndexedList = listOf("A", "B", "C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class Item(num: Int, state: MutableState<Boolean>) {
    val text: String = "Switch $num"
    val isOn: MutableState<Boolean> = state
}

@Composable
fun Screen(modifier: Modifier = Modifier) {


    val items = mutableListOf<Item>(
        Item(1, remember { mutableStateOf(false) }),
        Item(2, remember { mutableStateOf(false) }),
        Item(3, remember { mutableStateOf(false) }),
        )

    LazyColumn(modifier = modifier) {
        items(count = items.size) {i ->
            Row(modifier = Modifier.fillMaxWidth().height(80.dp).padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
                ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "|  ${items[i].text}".trimMargin(),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Justify
                    )
                Spacer(
                    modifier = Modifier.weight(1.0F),
                    )
                Switch(
                    modifier = Modifier.scale(1.4F).padding(40.dp),
                    checked = items[i].isOn.value,
                    onCheckedChange = {items[i].isOn.value = it},
                    )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,

    )
@Composable

fun GreetingPreview() {

    MyApplicationTheme {

        Screen()

    }

}