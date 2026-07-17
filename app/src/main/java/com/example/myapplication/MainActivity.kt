package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    screen( modifier = Modifier.padding(innerPadding))



                //
//                    // Tworzymy pionową kolumnę
//                    LazyColumn(
//                        modifier = Modifier
//                            .padding(innerPadding) // Przekazujemy margines, aby napisy nie weszły pod paski systemowe
//                            .fillMaxSize()// Kolumna zajmie cały dostępny ekran
//                    ) {
//                        items(count = items.size,) {
//                            Text("Item is $it")
//                        }
//                    }
                }
            }
        }
    }
}

@Composable
fun screen(modifier: Modifier = Modifier) {
    val items = mutableListOf("test", "Test", "TEST", )

    LazyColumn(modifier = modifier) {
        items(count = items.size) {i -> Text("|  Item is ${items.get(i)}".trimMargin()) }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,

    )
@Composable

fun GreetingPreview() {

    MyApplicationTheme {

        screen()

    }

}