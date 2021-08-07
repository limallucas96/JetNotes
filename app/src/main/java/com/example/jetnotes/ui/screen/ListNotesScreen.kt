package com.example.jetnotes.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ListNotesScreen(floatingButtonAction: () -> Unit = {}) {
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

            AppList(modifier = Modifier
                .fillMaxSize()
                .constrainAs(appList) {
                    top.linkTo(appToolbar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            AppFloatingActionButton(
                modifier = Modifier
                    .constrainAs(appFloating) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                floatingButtonAction.invoke()
            }
        }
    }
}