package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnotes.R
import com.example.jetnotes.ui.theme.JetNotesTheme


@Preview(showBackground = true)
@Composable
fun EmptyStateComposePreview() {
    JetNotesTheme {
        EmptyStateCompose()
    }
}

@Composable
fun EmptyStateCompose() {
    JetNotesTheme {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_note_alert),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = stringResource(id = R.string.empty_notes),
                fontSize = 24.sp
            )
        }
    }
}