package com.example.tta.features.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tta.R
import com.example.tta.ui.common.TTABackground
import com.example.tta.ui.common.TTANavBar
import com.example.tta.ui.theme.FinalOrangeApp
import com.example.tta.ui.theme.TTATheme


@Composable
fun DiaryScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { FloatingsActionButton() },
        bottomBar = { TTANavBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiaryBody()
        }
    }
}

@Composable
fun DiaryBody(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TTABackground()
        Column(modifier = Modifier.fillMaxSize()) {
            DiaryHeader()
            CallToActionCard()
        }
    }

}

@Composable
fun DiaryHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.diario_de_gratitud),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier
                .padding(top = 68.dp, bottom = 32.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 114.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = stringResource(R.string.hoy), style = MaterialTheme.typography.headlineLarge.copy(
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.White
                )
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}




@Composable
fun CallToActionCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.img_empty_note)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 52.dp, start = 60.dp, end = 60.dp),
            text = stringResource(R.string.por_qu_te_sientes_agradecido_hoy),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 20.sp,
                lineHeight = TextUnit(25f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(155.dp)
                .height(100.dp)
                .align(alignment = Alignment.CenterHorizontally),
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = stringResource(R.string.empty_thank_you_note_quote),
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp, start = 48.dp, end = 48.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.W300,
                color = Color.Black
            )
        )
        Text(
            text = stringResource(R.string.melody_beattie), textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.W300,
                color = Color.Black
            )
        )
    }


}

@Composable
private fun FloatingsActionButton(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 6.dp),
            text = stringResource(R.string.escribe_en_tu_diario),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 17.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )
        )
        Image(
            modifier = Modifier
                .padding(top = 2.dp)
                .size(24.dp),

            painter = painterResource(id = R.drawable.ic_keyboard_backspace),
            contentDescription = null,
            contentScale = ContentScale.Inside,
        )
        FloatingActionButton(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .size(56.dp),

            shape = MaterialTheme.shapes.extraLarge,
            onClick = { /*TODO*/ },
            containerColor = FinalOrangeApp
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun DiaryScreenPreview(modifier: Modifier = Modifier) {
    TTATheme {
        DiaryScreen()
    }

}

@Preview(showBackground = true)
@Composable
private fun CallToActionCardPreview() {
    TTATheme { CallToActionCard() }
}

@Preview(showBackground = true)
@Composable
private fun FloatingsActionButtonPreview() {
    TTATheme { FloatingsActionButton() }
}

