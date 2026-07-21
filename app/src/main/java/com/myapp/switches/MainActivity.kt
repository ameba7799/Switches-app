package com.myapp.switches

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        changeAppIcon(context = this)
    }
}

fun changeAppIcon(context: Context) {
    val packageManager = context.packageManager
    val packageName = context.packageName

    val offIcon = ComponentName(packageName, "$packageName.Off")
    val onIcon = ComponentName(packageName, "$packageName.On")

    val offEnabled =
        packageManager.getComponentEnabledSetting(offIcon) !=
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED


    packageManager.setComponentEnabledSetting(
        offIcon,
        if (offEnabled) PackageManager.COMPONENT_ENABLED_STATE_DISABLED
        else PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP
    )

    packageManager.setComponentEnabledSetting(
        onIcon,
        if (offEnabled) PackageManager.COMPONENT_ENABLED_STATE_ENABLED
        else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
        PackageManager.DONT_KILL_APP
    )
}
