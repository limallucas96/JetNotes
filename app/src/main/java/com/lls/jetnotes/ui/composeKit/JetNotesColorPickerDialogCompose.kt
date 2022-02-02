package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.extensions.parse
import com.lls.jetnotes.ui.theme.*
import entities.NotesColor

@ExperimentalMaterialApi
@Composable
@Preview
fun ColorPickerDialogComposePreview() {
    JetNotesTheme {
        ColorPickerDialogCompose(
            onColorPicked = {},
            clearColor = {},
            onDismiss = {}
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ColorPickerDialogComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        ColorPickerDialogCompose(
            onColorPicked = {},
            clearColor = {},
            onDismiss = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun ColorPickerDialogCompose(
    onColorPicked: (String) -> Unit,
    clearColor: () -> Unit,
    onDismiss: () -> Unit
) {

    val colors = NotesColor.getColors()

    AlertDialog(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        backgroundColor = MaterialTheme.colors.background,
        onDismissRequest = { onDismiss.invoke() },
        title = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.dialog_color_picker_title),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_color_picker_off),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.CenterEnd)
                        .clickable { clearColor.invoke() }
                )
            }

        },
        text = {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.padding(8.dp),
                    cells = GridCells.Fixed(count = 3)
                ) {
                    items(colors.size) { colorIndex ->
                        Surface(
                            modifier = Modifier.padding(8.dp),
                            color = Color.Transparent
                        ) {
                            val color = colors[colorIndex]
                            Canvas(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable { onColorPicked.invoke(color.hex) },
                                onDraw = {
                                    val size = 50.dp.toPx()
                                    drawCircle(
                                        color = Color.parse(color.hex),
                                        radius = size / 2f
                                    )
                                })
                        }
                    }
                }
            }
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.dismiss),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable { onDismiss.invoke() }
                )
            }
        }
    )
}