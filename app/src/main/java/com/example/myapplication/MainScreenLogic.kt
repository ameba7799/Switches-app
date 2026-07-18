package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import kotlin.random.Random

class MainScreenLogic(initialSize: Int = 3) {
    val items = mutableStateListOf<Item>().apply {
        addAll(List(initialSize) { i -> Item(num = i + 1) })
    }
    private var isWon = false
    private var onChance = 0.5
    private val minOnChance = 0.0
    private var offChance = 0.0
    private val maxOffChance = 0.5
    private var newChance = 0.5
    private val minNewChance = 0.0

    fun change(item: Item) {
        for (i in items ) {

            if (i === item) {
                i.isOn = !i.isOn
                continue
            }

            if (i.isOn) {
                i.isOn = !checkChance(onChance)
            } else {
                i.isOn = checkChance(offChance)
            }
        }

        if (checkChance(newChance)) {
            addItem()
        }
    }

    private fun checkChance(value: Double) : Boolean {
        return Random.nextDouble(0.0, 1.0) <= value
    }

    private fun addItem() {
        items.add(Item(items.size+1))

        if (onChance > minOnChance) { onChance -= 0.01 }
        if (offChance < maxOffChance) { offChance += 0.05 }
        if (newChance > minNewChance) { newChance -= 0.01 }
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