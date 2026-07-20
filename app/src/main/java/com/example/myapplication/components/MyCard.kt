package com.example.myapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.BackgroundColor

@Composable
fun MyCard(modifier: Modifier = Modifier,
           isColored: Boolean,
           color: Color,
           content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(
            width = 4.dp,
            color = if (isColored && isSystemInDarkTheme()) color else BackgroundColor()
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isColored && !isSystemInDarkTheme()) color else BackgroundColor()
        ),
        content = content
    )

}