package com.myapp.switches.mainscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.myapp.switches.ui.theme.getRandomColor
import kotlin.random.Random


class MainScreenLogic(initialSize: Int = 3, val onWin: () -> Unit = {null}) {

    class SwitchData(initialValue: Boolean = false, color: Color) {
        var isOn by mutableStateOf(initialValue)
        val color: Color = color
    }
    val switches = mutableStateListOf<SwitchData>()
    init {
        for (i in 1..initialSize) {
            addSwitch()
        }
    }

    private var onChance = 0.7
    private val minOnChance = 0.01
    private var offChance = 0.1
    private val maxOffChance = 0.7
    private var newChance = 0.9
    private val minNewChance = 0.01

    fun change(index: Int, value: Boolean) {
        if (index !in switches.indices) {
            return
        }

        switches.forEach { switch ->
            switch.isOn =
                if (switch.isOn) !checkChance(onChance) else checkChance(offChance)
        }

        switches[index].isOn = value

        if (checkChance(newChance)) {
            addSwitch()
        }

        checkWin()
    }

    fun getValue(index: Int): Boolean {
        return switches[index].isOn
    }

    fun getSize(): Int {
        return switches.size
    }

    fun getColor(index: Int): Color {
        return switches[index].color
    }

    private fun checkChance(value: Double) : Boolean {
        return Random.nextDouble(0.0, 1.0) <= value
    }

    private fun onAddSwitch() {
        if (onChance > minOnChance) { onChance -= 0.15 * (onChance - minOnChance) }
        if (offChance < maxOffChance) { offChance += 0.15 * (maxOffChance - offChance) }
        if (newChance > minNewChance) { newChance -= 0.05 * (newChance - minNewChance) }
    }

    private fun checkWin() {
        if (switches.all { it.isOn }) {
            onWin()
        }
    }

    private fun addSwitch() {
        onAddSwitch()

        var tmp: SwitchData
        do {
            tmp = SwitchData(color = getRandomColor())
        } while (switches.isNotEmpty() && switches.last().color == tmp.color)
        switches.add(tmp)
    }
}