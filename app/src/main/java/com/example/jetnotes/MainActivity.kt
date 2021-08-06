package com.example.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetnotes.ui.theme.JetNotesTheme
import com.example.jetnotes.ui.theme.screen.*

class MainActivity : ComponentActivity() {

    @Composable
    private fun MainActivityScreen() {
        MyApp {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
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
                    //TODO: FloatingButton action
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetNotesTheme { MainActivityScreen() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainActivityScreen() }
    }

}


