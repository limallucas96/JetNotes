package com.example.jetnotes.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import com.google.accompanist.navigation.animation.composable
import com.example.jetnotes.ui.screen.createNote.CreateNoteScreen
import com.example.jetnotes.ui.screen.listNotes.ListNotesScreen
import kotlinx.coroutines.InternalCoroutinesApi

sealed class NavigationScreen(val route: String, val arguments: List<NamedNavArgument> = listOf()) {

    object NotesList : NavigationScreen(
        route = "notesList"
    )

    object CreateNote : NavigationScreen(
        route = "createNote"
    )
}

@ExperimentalAnimationApi
private fun fadeOutAnimation(width: Int) = slideOutHorizontally(
    targetOffsetX = { -width },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
) + fadeOut(animationSpec = tween(300))

@ExperimentalAnimationApi
private fun fadeInAnimation(width: Int) = slideInHorizontally(
    initialOffsetX = { -width },
    animationSpec = tween(
        durationMillis = 300,
        easing = FastOutSlowInEasing
    )
) + fadeIn(animationSpec = tween(300))

@OptIn(InternalCoroutinesApi::class)
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addNotesList(
    navController: NavController,
    width: Int,
) {
    composable(
        route = NavigationScreen.NotesList.route,
        exitTransition = { _, _ ->
            fadeOutAnimation(width)
        },
        popEnterTransition = { _, _ ->
            fadeInAnimation(width)
        },
    ) {
        ListNotesScreen {
            navController.navigate(NavigationScreen.CreateNote.route)
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addCreateNote(
    navController: NavController,
    width: Int
) {
    composable(
        route = NavigationScreen.CreateNote.route,
        exitTransition = { _, _ ->
            fadeOutAnimation(width)
        },
        popEnterTransition = { _, _ ->
            fadeInAnimation(width)
        },
    ) {
        CreateNoteScreen { navController.popBackStack() }
    }
}

