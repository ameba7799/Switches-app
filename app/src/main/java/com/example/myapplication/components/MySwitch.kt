package com.example.myapplication.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.BackgroundColor
import com.example.myapplication.ui.theme.OnBackgroundColor


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
fun MySwitchColors(color: Color): SwitchColors =
    SwitchDefaults.colors(
        checkedThumbColor = MyThumbColor(color),
        checkedTrackColor = MyTrackColor(color),
        checkedBorderColor = OnBackgroundColor(),
        uncheckedThumbColor = OnBackgroundColor(),
        uncheckedTrackColor = BackgroundColor(),
        uncheckedBorderColor = OnBackgroundColor()
    )

@Composable
fun MyThumbColor(color: Color): Color =
    if (isSystemInDarkTheme()) color else OnBackgroundColor()

@Composable
fun MyTrackColor(color: Color): Color =
    if (isSystemInDarkTheme()) BackgroundColor() else color

@Composable
fun MyBorderColor(color: Color): Color =
    if (isSystemInDarkTheme()) color else OnBackgroundColor()