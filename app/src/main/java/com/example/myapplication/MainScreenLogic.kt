package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import kotlin.random.Random

class MainScreenLogic(initialSize: Int = 3) {
    val items = mutableStateListOf<Item>().apply {
        addAll(List(initialSize) { i -> Item(num = i + 1) })
    }
    private var isWon = false
    private val ON_CHANCE = 0.5
    private val OFF_CHANCE = 0.5

    fun change(item: Item) {
        for (i in items ) {

            if (i === item) {
                i.isOn = !i.isOn
                continue
            }

            if (i.isOn) {
                i.isOn = !(Random.nextDouble(0.0, 1.0) <= ON_CHANCE)
            } else {
                i.isOn = Random.nextDouble(0.0, 1.0) <= OFF_CHANCE
            }
        }
    }
}




//class MainScreenLogic(initialSize: Int = 3) {
//
//
//    var isWon by mutableStateOf(false)
//        private set
//
//    fun toggleItemAt(index: Int) {
//
//        // 3. Sprawdź warunek wygranej (np. wszystkie przełączniki są włączone)
//        checkWinCondition()
//    }
//
//    private fun checkWinCondition() {
//        isWon = items.all { it.isOn }
//    }
//}