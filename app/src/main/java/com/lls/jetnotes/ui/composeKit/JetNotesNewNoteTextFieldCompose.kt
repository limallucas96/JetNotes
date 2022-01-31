package com.lls.jetnotes.ui.composeKit

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
import com.lls.jetnotes.ui.theme.JetNotesTheme

@Preview()
@Composable
fun NewNoteTextFieldPreview() {
    JetNotesTheme {
        NewNoteTextField(textState = remember { mutableStateOf(TextFieldValue()) })
    }
}

@Preview()
@Composable
fun NewNoteTextFieldPreviewDark() {
    JetNotesTheme(darkTheme = true) {
        NewNoteTextField(textState = remember { mutableStateOf(TextFieldValue()) })
    }
}

@Composable
fun NewNoteTextField(
    modifier: Modifier = Modifier,
    textState: MutableState<TextFieldValue>
) {
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
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )

}