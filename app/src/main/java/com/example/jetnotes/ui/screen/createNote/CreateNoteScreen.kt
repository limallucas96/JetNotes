package com.example.jetnotes.ui.screen.createNote

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.jetnotes.ui.composeKit.AppTextField
import com.example.jetnotes.ui.composeKit.AppToolbar
import com.example.jetnotes.ui.composeKit.MyApp

@Composable
fun CreateNoteScreen() {
    MyApp {
        Column {
            AppToolbar {}
            AppTextField()
        }
    }
}