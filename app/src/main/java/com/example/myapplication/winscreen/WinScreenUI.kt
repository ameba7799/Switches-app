package com.example.myapplication.winscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.components.MyColumn

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun WinScreen(modifier: Modifier = Modifier) {
    MyColumn() {
        Text(
            text = "YOU WIN !",
            fontSize = 50.sp,
        )
    }
}