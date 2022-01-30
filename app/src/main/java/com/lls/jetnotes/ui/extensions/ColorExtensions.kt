package com.lls.jetnotes.ui.extensions

import androidx.compose.ui.graphics.Color

fun Color.Companion.parse(colorString: String): Color =
    Color(color = android.graphics.Color.parseColor(colorString))