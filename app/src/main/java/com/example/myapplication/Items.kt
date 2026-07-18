package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Item(val num: Int, initialValue: Boolean = false) {
    val text: String = "Switch $num"
    var isOn by mutableStateOf(initialValue)
}