package com.lls.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.theme.JetNotesTheme


@Preview(showBackground = true)
@Composable
fun AppToolbarComposePreview() {
    JetNotesTheme {
        AppToolbarCompose()
    }
}

@Composable
fun AppToolbarCompose(
    primaryAction: (() -> Unit)? = null,
    secondaryAction: (() -> Unit)? = null,
    moreAction: (() -> Unit)? = null,
) {

    val context = LocalContext.current
    val expanded = remember { mutableStateOf(false) }

    JetNotesTheme {
        TopAppBar(
            modifier = Modifier.padding(),
            title = { Text(text = context.getString(R.string.app_name)) },
            actions = {

                primaryAction?.let { primary ->
                    IconButton(onClick = {
                        primary.invoke()
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                }

                secondaryAction?.let { secondary ->
                    IconButton(onClick = {
                        secondary.invoke()
                    }) {
                        Icon(Icons.Filled.Done, contentDescription = "")
                    }

                }

                moreAction?.let { more ->
                    Box(
                        Modifier
                            .wrapContentSize(Alignment.TopEnd)
                    ) {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = "Localized description"
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false },
                    ) {
                        DropdownMenuItem(onClick = {
                            expanded.value = false
                        }) {
                            Text("First Item")
                        }

                        DropdownMenuItem(onClick = {
                            expanded.value = false
                        }) {
                            Text("Second item")
                        }

                        Divider()

                        DropdownMenuItem(onClick = {
                            expanded.value = false
                        }) {
                            Text("Third item")
                        }

                        Divider()

                        DropdownMenuItem(onClick = {
                            expanded.value = false
                        }) {
                            Text("Fourth item")
                        }
                    }

                }
            }
        )

    }
}