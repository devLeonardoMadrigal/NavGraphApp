package com.example.navgraphapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(customName:String, onCustomNameChange: (String)-> Unit, onNavigateToDetail: () -> Unit) {

    var isButtonEnabled by remember { mutableStateOf(false) }

    Column() {
        Text("HomeScreen")
        TextField(
            value = customName,
            onValueChange = { newText ->
                onCustomNameChange(newText)
                isButtonEnabled = newText.isNotEmpty()

            }
        )
        Button(onClick = onNavigateToDetail, enabled = isButtonEnabled) {
            Text("Check details")
        }
    }

}