package com.example.jetnotes.ui.composeKit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.jetnotes.R

//TODO: Create single toolbar for the whole app.
@Composable
fun AppToolbar(modifier: Modifier = Modifier, action: () -> Unit) {
    val context = LocalContext.current
    TopAppBar(
        modifier = modifier,
        title = { Text(text = context.getString(R.string.app_name)) },
        actions = {
            IconButton(onClick = {
                action.invoke()
            }) {
//                Icon(painterResource(R.drawable.ic_launcher_foreground), contentDescription = "")
            }
        }
    )
}

@Composable
fun AppTextField(textState: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) }) {
    TextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
}

@Composable
fun AppList(modifier: Modifier = Modifier, notes: List<String>) {
    LazyColumn(modifier = modifier) {
        items(notes, key = { it }) { note ->
            Text(text = note)
        }
    }
}

@Composable
fun AppFloatingActionButton(modifier: Modifier = Modifier, action: () -> Unit) {
    FloatingActionButton(
        onClick = { action.invoke() },
        modifier = modifier
            .padding(32.dp)
            .width(64.dp)
            .height(64.dp)
    ) {
        Icon(Icons.Filled.Add, contentDescription = "")
    }
}