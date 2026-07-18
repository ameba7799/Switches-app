package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Preview(
    showBackground = true,
    showSystemUi = true,
    )
@Composable
fun MainScreen (modifier: Modifier = Modifier) {
    val logic = remember { MainScreenLogic() }
    
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainScreenContent(
                modifier = Modifier.padding(innerPadding),
                logic = logic
            )
        }
    }
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier, logic: MainScreenLogic) {
    LazyColumn(modifier = modifier) {
        item {
            MainScreenText(Modifier.fillMaxWidth().padding(horizontal = 8.dp))
        }
        logic.items.forEach { item ->
            item {
                MainScreenSwitchRow (item = item, logic = logic)
            }
        }
    }
}

@Composable
fun MainScreenText(modifier: Modifier = Modifier) {
    Column(modifier = modifier.height(160.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = modifier,
            text = "SWITCH ON",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = modifier.padding(4.dp),
            text = "ALL",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(1000)
        )
        Text(
            modifier = modifier,
            text = "THE SWITCHES",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun MainScreenSwitchRow (modifier: Modifier = Modifier, item: Item, logic: MainScreenLogic) {
    Row(modifier = Modifier.fillMaxWidth().height(80.dp).padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = item.text,
            fontSize = 25.sp,
        )
        Spacer(
            modifier = Modifier.weight(1.0F),
        )
        Switch(
            modifier = Modifier.scale(1.4F).padding(40.dp),
            checked = item.isOn,
            onCheckedChange = {
                logic.change(item)
            },
        )
    }
}
