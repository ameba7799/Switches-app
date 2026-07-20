package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySwitch (modifier: Modifier = Modifier,
              checked: Boolean,
              color: Color,
              onCheckedChange: (Boolean) -> Unit) {
    Switch(
        modifier = modifier.scale(1.4F).padding(8.dp),
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = MySwitchColors(color)
    )
}



@Composable
fun MySwitchColors(color: Color = Color.Gray): SwitchColors =
    SwitchDefaults.colors(
        checkedThumbColor = MaterialTheme.colorScheme.onBackground,
        checkedTrackColor = color,
        checkedBorderColor = MaterialTheme.colorScheme.onBackground,
        uncheckedThumbColor = MaterialTheme.colorScheme.onBackground,
        uncheckedTrackColor = MaterialTheme.colorScheme.background,
        uncheckedBorderColor = MaterialTheme.colorScheme.onBackground
    )