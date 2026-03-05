package com.example.navgraphapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(onNavigateToDetail: () -> Unit) {
    Column() {
        Text("HomeScreen")
        Button(onClick = onNavigateToDetail) {
            Text("Details")
        }
    }

}