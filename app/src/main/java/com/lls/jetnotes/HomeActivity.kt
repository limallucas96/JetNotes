package com.lls.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.lls.jetnotes.ui.navigation.NavigationScreen
import com.lls.jetnotes.ui.navigation.addCreateNote
import com.lls.jetnotes.ui.navigation.addNotesList
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lls.jetnotes.ui.screen.listNotes.ListNotesScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberAnimatedNavController()
            AnimatedNavHost(
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


