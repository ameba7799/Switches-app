package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import kotlin.random.Random

class MainScreenLogic(initialSize: Int = 3, val onWin: () -> Unit = {null}) {
    val items = mutableStateListOf<Item>().apply {
        addAll(List(initialSize) { i -> Item(num = i + 1) })
    }
    private var onChance = 0.7
    private val minOnChance = 0.01
    private var offChance = 0.1
    private val maxOffChance = 0.7
    private var newChance = 0.9
    private val minNewChance = 0.01

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

        checkWin()
    }

    private fun checkChance(value: Double) : Boolean {
        return Random.nextDouble(0.0, 1.0) <= value
    }

    private fun addItem() {
        items.add(Item(items.size+1))

        if (onChance > minOnChance) { onChance -= 0.15 * (onChance - minOnChance) }
        if (offChance < maxOffChance) { offChance += 0.15 * (maxOffChance - offChance) }
        if (newChance > minNewChance) { newChance -= 0.05 * (newChance - minNewChance) }
    }

    private fun checkWin() {
        if (items.all { it.isOn }) {
            onWin()
        }
    }
}