package com.example.jetnotes.ui.screen.listNotes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jetnotes.HomeActivity
import com.example.jetnotes.ui.composeKit.ComposeTestTags
import com.example.jetnotes.ui.navigation.NavigationScreen
import com.example.jetnotes.ui.theme.JetNotesTheme
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest

@ExperimentalAnimationApi
@InternalCoroutinesApi
@OptIn(ExperimentalComposeUiApi::class)
@RunWith(AndroidJUnit4::class)
class ListNotesScreenTest : KoinTest {

    /* TODO
     *  1. test empty state
     *  2. test list
     *  3. test dark/light mode
     *
     */


//    @Rule
//    val koinRule = KoinTestRule.create()


    @get:Rule
    val composeRule = createAndroidComposeRule<HomeActivity>()

//    @Before
//    fun setup() {
//        startKoin {
//            allowOverride(true)
//            androidContext(composeRule.activity)
//            modules(appModulesMock + domainModulesMock + dataModulesMock)
//        }
//    }

    @Before
    fun setup() {
//
//        startKoin {
//            allowOverride(true)
//            androidContext(composeRule.activity)
//            modules(appModulesMock + domainModulesMock + dataModulesMock)
//        }


        composeRule.setContent {
            val navController = rememberNavController()
            JetNotesTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavigationScreen.NotesList.route
                ) {
                    composable(route = NavigationScreen.NotesList.route) {
                        ListNotesScreen()
                    }
                }
            }
        }
    }

    @Test
    fun temp2() {
        composeRule.onNodeWithTag(ComposeTestTags.TEMP_TEST_TAG).assertDoesNotExist()
    }


}