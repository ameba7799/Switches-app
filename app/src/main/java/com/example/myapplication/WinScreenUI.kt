package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun WinScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(
            modifier = Modifier.weight(1.0F),
        )
        Text(
            modifier = modifier,
            text = "YOU WIN !",
            fontSize = 50.sp,
        )
        Spacer(
            modifier = Modifier.weight(1.0F),
        )
    }
}