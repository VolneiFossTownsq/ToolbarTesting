package com.example.toolbartesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.toolbartesting.list.ListSection
import com.example.toolbartesting.list.NameItem
import com.example.toolbartesting.list.namesList
import com.example.toolbartesting.title.TitleSection
import com.example.toolbartesting.toolbar.Toolbar
import com.example.toolbartesting.ui.theme.ToolbarTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolbarTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ToolbarTestingApp(namesList)
                }
            }
        }
    }
}

@Composable
fun ToolbarTestingApp(namesList: List<String>) {
    val scrollState = rememberLazyListState()

    Scaffold(
        topBar = {
            var appBarTitle by remember { mutableStateOf("") }
            val titleOpacity = remember { Animatable(1f) }

            LaunchedEffect(scrollState) {
                snapshotFlow { scrollState.firstVisibleItemIndex }
                    .collect { index ->
                        val newTitle = if (index > 0) "Testing Scroll app bar" else ""
                        if (appBarTitle != newTitle) {
                            titleOpacity.animateTo(
                                targetValue = 0f,
                                animationSpec = tween(durationMillis = 500, easing = LinearEasing)
                            )
                            appBarTitle = newTitle
                            titleOpacity.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(durationMillis = 500, easing = LinearEasing)
                            )
                        }
                    }
            }

            Toolbar(
                title = {
                    Text(
                        text = appBarTitle,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black.copy(alpha = titleOpacity.value)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            state = scrollState
        ) {
            item {
                TitleSection()
            }
            items(namesList) { name ->
                NameItem(name = name)
            }
        }
    }
}
