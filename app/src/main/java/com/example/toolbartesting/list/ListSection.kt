package com.example.toolbartesting.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListSection(names: List<String>) {
    LazyColumn {
        items(names) {name ->
            NameItem(name = name)
        }
    }
}

@Composable
fun NameItem(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        Text(text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight(200),
            letterSpacing = 4.sp

        )
    }
}

@Preview
@Composable
fun NameItemPreview(){
    NameItem(name = "Volnei")
}