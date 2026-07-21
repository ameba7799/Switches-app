package com.myapp.switches

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.myapp.switches.mainscreen.MainScreen
import com.myapp.switches.ui.theme.MyApplicationTheme
import com.myapp.switches.winscreen.WinScreen

enum class Screens {
    MAIN,
    WIN
}

@Composable
fun App () {
    var currentScreen by remember { mutableStateOf(Screens.MAIN) }

    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when (currentScreen) {
                Screens.MAIN -> {
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        onWin = { currentScreen = Screens.WIN }
                    )
                }
                Screens.WIN -> {
                    WinScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

