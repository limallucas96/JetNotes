package com.lls.data.base

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
abstract class BaseDataTest  {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
}