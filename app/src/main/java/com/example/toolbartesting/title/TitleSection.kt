package com.example.toolbartesting.title

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleSection() {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Testing Scroll app bar",
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth()
        )
    }
}