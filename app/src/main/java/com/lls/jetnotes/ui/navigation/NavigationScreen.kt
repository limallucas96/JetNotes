package com.lls.jetnotes.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.lls.jetnotes.ui.screen.createNote.CreateNoteScreen
import com.lls.jetnotes.ui.screen.listNotes.ListNotesScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lls.jetnotes.ui.navigation.NavigationScreen.CreateNote.Arguments.NOTE_ID
import kotlinx.coroutines.InternalCoroutinesApi

sealed class NavigationScreen(val route: String, val arguments: List<NamedNavArgument> = listOf()) {

    data object NotesList : NavigationScreen(
        route = "notesList"
    )

    data object CreateNote : NavigationScreen(
        route = "createNote/{$NOTE_ID}"
    ) {
        fun createRoute(noteId: String? = null) = "createNote/${noteId}"

        object Arguments {
            const val NOTE_ID = "noteId"
        }

    }
}

@OptIn(InternalCoroutinesApi::class)
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addNotesList(
    navController: NavController
) {
    composable(
        route = NavigationScreen.NotesList.route,
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        },
        popEnterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        },
        arguments = listOf(
            navArgument(NOTE_ID) {
                type = NavType.IntType
                nullable = false
                defaultValue = -1
            })
    ) {
        ListNotesScreen(onCreateNewNote = { noteId ->
            navController.navigate(NavigationScreen.CreateNote.createRoute(noteId.toString()))
        })
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addCreateNote(
    navController: NavController
) {
    composable(
        route = NavigationScreen.CreateNote.route,
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        },
        popEnterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300))
        }
    ) { navBackStackEntry ->
        val noteId = navBackStackEntry.arguments?.getString(NOTE_ID, "").orEmpty()
        CreateNoteScreen(navController, noteId.toIntOrNull())
    }
}

