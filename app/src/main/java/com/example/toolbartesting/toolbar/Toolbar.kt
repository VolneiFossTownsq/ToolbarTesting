package com.example.toolbartesting.toolbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(title: @Composable () -> Unit) {
    TopAppBar(title =  title)
}