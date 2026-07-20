package com.example.myapplication

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.components.MyColumn
import com.example.myapplication.ui.components.MyRow
import com.example.myapplication.ui.components.MySwitch

@Preview(
    showBackground = true,
    showSystemUi = true,
    )
@Composable
fun MainScreen (
    modifier: Modifier = Modifier,
    onWin: () -> Unit = {null},
) {
    val logic = remember { MainScreenLogic(initialSize = 3, onWin = onWin) }

    LazyColumn(modifier = modifier) {
        item {
            MainScreenText()
        }
        items(count = logic.getSize()) {i ->
            MainScreenSwitchRow (index = i, logic = logic)
        }
    }
}

@Composable
fun MainScreenText(modifier: Modifier = Modifier) {
    MyColumn(modifier = modifier,
    ) {
        Text(
            text = "SWITCH ON",
            fontSize = 35.sp,
        )
        Text(
            text = "ALL",
            fontSize = 40.sp,
            fontWeight = FontWeight(1000)
        )
        Text(
            text = "THE SWITCHES",
            fontSize = 35.sp,
        )
    }
}

@Composable
fun MainScreenSwitchRow (modifier: Modifier = Modifier, index: Int, logic: MainScreenLogic) {
    MyRow() {
        Text(
            text = "Switch $index",
            fontSize = 25.sp,
        )
        Spacer(
            modifier = Modifier.weight(1.0F),
        )
        MySwitch(
            color = logic.getColor(index),
            checked = logic.getValue(index),
            onCheckedChange = {
                logic.change(index, it)
            },
        )
    }
}
