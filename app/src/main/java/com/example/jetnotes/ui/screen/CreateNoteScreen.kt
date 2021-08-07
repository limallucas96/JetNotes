package com.example.jetnotes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun CreateNoteScreen() {
    MyApp {
        Column {
            AppToolbar {}
            AppTextField()
        }
    }
}