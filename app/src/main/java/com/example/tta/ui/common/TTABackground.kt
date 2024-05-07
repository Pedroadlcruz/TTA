package com.example.tta.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tta.R
import com.example.tta.ui.theme.TTATheme

@Composable
fun TTABackground(modifier: Modifier = Modifier, image: Int = R.drawable.bg_main_purple) {
    val painter = painterResource(id = image)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth

    )
}
@Preview(showBackground = true)
@Composable
private fun TTABackgroundPreview() {
    TTATheme { TTABackground() }
}