package com.lls.jetnotes.ui.composeKit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.theme.JetNotesTheme

@ExperimentalMaterialApi
@Composable
@Preview
fun ShortCutComposePreview() {
    JetNotesTheme {
        ShortCutCompose(R.drawable.ic_plus) {}
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ShortCutComposePreviewDark() {
    JetNotesTheme(darkTheme = true) {
        ShortCutCompose(R.drawable.ic_plus) {}
    }
}

@ExperimentalMaterialApi
@Composable
fun ShortCutCompose(
    @DrawableRes icon: Int,
    tintColor: Color? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(42.dp)
            .width(42.dp)
            .clickable { onClick.invoke() },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(id = icon),
            contentDescription = "",
            colorFilter = ColorFilter.tint(tintColor ?: Color.White)
        )
    }
}