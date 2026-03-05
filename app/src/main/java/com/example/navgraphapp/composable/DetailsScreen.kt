package com.example.navgraphapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(userId: String, onGoBack: () -> Unit) {
    Column() {
        Text("DetailsScreen")
        Text("Hello $userId")
        Button(onClick = onGoBack) {
            Text("Go Back")
        }
    }

}