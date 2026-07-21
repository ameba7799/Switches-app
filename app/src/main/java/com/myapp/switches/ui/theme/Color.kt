package com.myapp.switches.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun OnBackgroundColor(): Color =
    MaterialTheme.colorScheme.onBackground

@Composable
fun BackgroundColor(): Color =
    MaterialTheme.colorScheme.background

val colorsList = listOf(
    Color(0xFFEF9A9A),
    Color(0xFFF48FB1),
    Color(0xFFCE93D8),
    Color(0xFFB39DDB),
    Color(0xFF9FA8DA),
    Color(0xFF90CAF9),
    Color(0xFF81D4FA),
    Color(0xFF80DEEA),
    Color(0xFF80CBC4),
    Color(0xFFA5D6A7),
    Color(0xFFC5E1A5),
    Color(0xFFE6EE9C),
    Color(0xFFFFE082),
    Color(0xFFFFCC80),
    Color(0xFFFFAB91),
)

fun getRandomColor(): Color {
    return colorsList[Random.nextInt(0, colorsList.size)]
}

@Composable
fun AnimateColor (): Color{
    var time = 2500
    var color = remember { mutableStateOf(getRandomColor()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(time.toLong())
            var tmp: Color
            do {
                tmp = getRandomColor()
            } while (tmp == color.value)
            color.value = tmp
        }
    }

    val animatedColor = animateColorAsState(
        targetValue = color.value,
        animationSpec = tween(durationMillis = time, easing = FastOutSlowInEasing)
    )
    return animatedColor.value
}