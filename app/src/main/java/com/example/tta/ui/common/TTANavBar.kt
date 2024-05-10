package com.example.tta.ui.common

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tta.R
import com.example.tta.ui.theme.TTATheme


@Composable
fun TTANavBar(modifier: Modifier = Modifier) {
    NavigationBar(
        contentColor = Color.White,
        containerColor = Color.White,
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = false,
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_book),
                    contentDescription = null
                )
            },
            label = { Text(text = stringResource(R.string.libros)) },
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            selected = false,
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = null
                )
            },
            label = { Text(text = stringResource(R.string.perfil)) },
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            selected = true,
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_diary),
                    contentDescription = null
                )
            },
            label = { Text(text = stringResource(R.string.diario)) },
            onClick = { /*TODO*/ },
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPreview() {
    TTATheme { TTANavBar() }
}