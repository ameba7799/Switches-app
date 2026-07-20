package com.example.myapplication.winscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.components.MyColumn
import com.example.myapplication.ui.theme.AnimateColor
import com.example.myapplication.ui.theme.BackgroundColor

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun WinScreen(modifier: Modifier = Modifier) {
    if (isSystemInDarkTheme()) {
        DarkWinScreen(modifier)
    } else {
        LightWinScreen()
    }
}

@Composable
fun DarkWinScreen (modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(
            width = 4.dp,
            color = AnimateColor()
        ),
        colors = CardDefaults.cardColors(containerColor = BackgroundColor()
        ),
    ) {
        WinText()
    }
}

@Composable
fun LightWinScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().background(
            color = AnimateColor()
        )
    ) {
        WinText()
    }
}


@Composable
fun WinText() {
    MyColumn() {
        Text(
            text = "YOU WIN !",
            fontSize = 50.sp,
        )
    }
}