package com.example.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jetnotes.ui.screen.ListNotesScreen
import com.example.jetnotes.ui.theme.JetNotesTheme
import com.example.jetnotes.ui.navigation.NavigationScreen
import com.example.jetnotes.ui.navigation.addCreateNote
import com.example.jetnotes.ui.navigation.addNotesList

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HomeActivity : ComponentActivity() {

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetNotesTheme {
            ListNotesScreen()
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


