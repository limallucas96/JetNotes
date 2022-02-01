package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.theme.*

@ExperimentalMaterialApi
@Composable
@Preview
fun ColorPickerDialogComposePreview() {
    JetNotesTheme {
        ColorPickerDialogCompose(
            onColorPicked = {},
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
            onDismiss = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun ColorPickerDialogCompose(
    onColorPicked: (Color) -> Unit,
    onDismiss: () -> Unit
) {

    val colors = listOf(
        DarkTerraCotta, MeatBrown, BoogerBuster,
        IguanaGreen, PurpleNavy, CyberGrape
    )

    AlertDialog(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        backgroundColor = MaterialTheme.colors.background,
        onDismissRequest = { onDismiss.invoke() },
        title = { Text(text = stringResource(id = R.string.dialog_color_picker_title)) },
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
                                    .clickable { onColorPicked.invoke(color) },
                                onDraw = {
                                    val size = 50.dp.toPx()
                                    drawCircle(
                                        color = color,
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
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onDismiss.invoke() }
                ) {
                    Text(
                        stringResource(id = R.string.dismiss),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    )
}