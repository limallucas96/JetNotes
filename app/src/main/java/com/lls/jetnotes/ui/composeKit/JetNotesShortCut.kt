package com.lls.jetnotes.ui.composeKit

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lls.jetnotes.R
import com.lls.jetnotes.ui.extensions.parse
import com.lls.jetnotes.ui.theme.JetNotesTheme

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ShortCutComposePreview() {
    JetNotesTheme {
        ShortCutCompose(R.drawable.ic_plus) {}
    }
}

@ExperimentalMaterialApi
@Composable
fun ShortCutCompose(
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {

    Surface(
        color = Color.parse("#595959")
    ) {
        Card(
            modifier = Modifier
                .height(42.dp)
                .width(42.dp)
                .clickable { onClick.invoke() },

            border = BorderStroke(16.dp, Color.Red),
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}