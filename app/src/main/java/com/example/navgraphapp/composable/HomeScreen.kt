package com.example.navgraphapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    customName: String,
    onCustomNameChange: (String) -> Unit,
    listOfStrings: MutableList<String>,
    onListOfStringsChange: (String) -> Unit,
    onNavigateToDetail: (String) -> Unit
) {

    var isButtonEnabled by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxWidth().safeContentPadding()) {
        Text("HomeScreen")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = customName,
            onValueChange = { newText ->
                onCustomNameChange(newText)
                isButtonEnabled = newText.isNotEmpty()
            }
        )
        Button(onClick = { onListOfStringsChange(customName) }, enabled = isButtonEnabled) {
            Text("Add to the list")
        }

        LazyColumn(Modifier.fillMaxWidth()) {
            items(listOfStrings){ currentItem ->
                Row(Modifier.fillMaxWidth().background(color = Color.LightGray), verticalAlignment = Alignment.CenterVertically){
                        Spacer(Modifier.height(24.dp))
                        Text("Name: $currentItem")
                        Spacer(Modifier.width(12.dp))
                        Button(onClick = { onNavigateToDetail(currentItem) }) {
                            Text("Check details")
                        }
                }
            }
        }
    }

}