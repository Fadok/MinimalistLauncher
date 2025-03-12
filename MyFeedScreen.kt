package com.minimalistlauncher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyFeedScreen(onClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("📅 My Feed", style = MaterialTheme.typography.h4)
            Button(onClick = onClose) { Text("⬅ Home") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Screen Time Usage
        Text("📊 Screen Time Today", style = MaterialTheme.typography.h6)
        Text("2 hr 45 min")
    }
}
