package com.example.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jetnotes.ui.theme.JetNotesTheme
import com.example.jetnotes.ui.theme.navigation.NavigationScreen
import com.example.jetnotes.ui.theme.navigation.addCreateNote
import com.example.jetnotes.ui.theme.navigation.addNotesList
import com.example.jetnotes.ui.theme.screen.*

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetNotesTheme {
            MainActivityScreen(Color.Red)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = NavigationScreen.NotesList.route,
                builder = {
                    addNotesList(navController)
                    addCreateNote(navController)
                }
            )
        }
    }

}


