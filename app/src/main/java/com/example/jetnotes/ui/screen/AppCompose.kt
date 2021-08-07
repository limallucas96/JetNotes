package com.example.jetnotes.ui.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.jetnotes.ui.theme.JetNotesTheme

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetNotesTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}