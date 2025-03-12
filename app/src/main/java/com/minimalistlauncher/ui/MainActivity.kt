package com.minimalistlauncher.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.minimalistlauncher.data.AppPreferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val essentialApps = AppPreferences.getEssentialApps(this)

        setContent {
            MinimalistHomeScreen(essentialApps)
        }
    }

    @Composable
    fun MinimalistHomeScreen(apps: List<String>) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text("Minimalist Launcher", style = MaterialTheme.typography.h4)

            LazyColumn {
                items(apps) { appName ->
                    Text(
                        text = appName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable { launchApp(appName) },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }

    private fun launchApp(appName: String) {
        val intent = packageManager.getLaunchIntentForPackage(appName)
        startActivity(intent)
    }
}
