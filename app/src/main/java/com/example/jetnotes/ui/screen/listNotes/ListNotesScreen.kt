package com.example.jetnotes.ui.screen.listNotes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnotes.ui.composeKit.AppFloatingActionButton
import com.example.jetnotes.ui.composeKit.AppList
import com.example.jetnotes.ui.composeKit.AppToolbar
import com.example.jetnotes.ui.composeKit.MyApp
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Composable
fun ListNotesScreen(floatingButtonAction: () -> Unit = {}) {

    val viewModel = viewModel(ListNotesScreenViewModel::class.java)

    val viewState by viewModel.notesFlow.collectAsState()

    MyApp {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (appToolbar, appList, appFloating) = createRefs()

            AppToolbar(modifier = Modifier
                .constrainAs(appToolbar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                //TODO: Toolbar action
            }

            AppList(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(appList) {
                        top.linkTo(appToolbar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                notes = viewState
            )

            AppFloatingActionButton(
                modifier = Modifier
                    .constrainAs(appFloating) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                viewModel.addNote()
                floatingButtonAction.invoke()
            }
        }
    }
}