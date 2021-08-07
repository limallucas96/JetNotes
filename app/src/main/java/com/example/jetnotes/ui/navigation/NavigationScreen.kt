package com.example.jetnotes.ui.navigation

import androidx.compose.animation.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import com.example.jetnotes.ui.screen.CreateNoteScreen
import com.example.jetnotes.ui.screen.ListNotesScreen

sealed class NavigationScreen (val route: String, val arguments: List<NamedNavArgument> = listOf()) {

    object NotesList: NavigationScreen(
        route = "notesList"
    )

    object CreateNote: NavigationScreen(
        route = "createNote"
    )
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addNotesList(
    navController: NavController,
    width: Int = 0, //TODO pass animation
) {
    composable(
        route = NavigationScreen.NotesList.route,
//        exitTransition = {_, _ ->
//            slideOutHorizontally(
//                targetOffsetX = { -width },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeOut(animationSpec = tween(300))
//        },
//        popEnterTransition = { initial, _ ->
//            slideInHorizontally(
//                initialOffsetX = { -width },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeIn(animationSpec = tween(300))
//        },
    ){
        ListNotesScreen() {
            navController.navigate(NavigationScreen.CreateNote.route)
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addCreateNote(
    navController: NavController,
    width: Int = 0, //TODO pass animation
) {
    composable(
        route = NavigationScreen.CreateNote.route,
//        exitTransition = {_, _ ->
//            slideOutHorizontally(
//                targetOffsetX = { -width },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeOut(animationSpec = tween(300))
//        },
//        popEnterTransition = { initial, _ ->
//            slideInHorizontally(
//                initialOffsetX = { -width },
//                animationSpec = tween(
//                    durationMillis = 300,
//                    easing = FastOutSlowInEasing
//                )
//            ) + fadeIn(animationSpec = tween(300))
//        },
    ){
        CreateNoteScreen()
    }
}

