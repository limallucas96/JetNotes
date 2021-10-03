package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnotes.ui.theme.JetNotesTheme

@Preview(showBackground = true)
@Composable
fun NewNoteTextFieldPreview() {
    JetNotesTheme {
        NewNoteTextField()
    }
}

@Composable
fun NewNoteTextField(textState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) }) {
    Surface(elevation = 4.dp) {
        TextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent

            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
        )
    }

}