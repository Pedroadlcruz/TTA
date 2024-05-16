package com.example.tta.features.tta_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tta.R
import com.example.tta.ui.common.TTANavBar
import com.example.tta.ui.theme.BgGray
import com.example.tta.ui.theme.ContentGray
import com.example.tta.ui.theme.DarkBlue
import com.example.tta.ui.theme.DisableGray
import com.example.tta.ui.theme.FinalOrangeApp
import com.example.tta.ui.theme.MiddleGray
import com.example.tta.ui.theme.SuccessGreen
import com.example.tta.ui.theme.TTADarkGray
import com.example.tta.ui.theme.TTATheme

@Composable
fun TtaTestScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { TTANavBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            TestBody()
        }
    }
}

@Composable
fun TestBody(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BgGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp,
                        shape = MaterialTheme.shapes.extraLarge,
                        ambientColor = Color.Black,
                        spotColor = Color.Black
                    )
                    .background(Color.White)
                    .size(40.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_keyboard_backspace_2),
                    contentDescription = null
                )
            }
            Text(
                text = "Test de la actitud",
                fontWeight = FontWeight.W600,
                fontSize = 17.sp,
                lineHeight = 20.72.sp,
                color = DarkBlue
            )
            Text(
                text = "20%",
                fontWeight = FontWeight.W600,
                fontSize = 17.sp,
                lineHeight = 20.72.sp,
                color = Color.Black
            )

        }
        LinearProgressIndicator(
            progress = 0.2f,
            color = SuccessGreen,
            trackColor = DisableGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp, top = 12.dp)
                .height(12.dp)
                .padding(horizontal = 24.dp),
            strokeCap = StrokeCap.Round
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿Con qué frecuencia te despiertas con mal humor?",
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                lineHeight = 28.38.sp,
                color = TTADarkGray,
                modifier = Modifier.padding(bottom = 40.dp, top = 16.dp)
            )

            AnswerButton(index = "A)", text = "Casi todos los días")
            AnswerButton(index = "B)", text = "Frecuentemente")
            AnswerButton(index = "C)", text = "Raras veces", isSelect = true)
            AnswerButton(index = "D)", text = "Nunca")

        }
    }
}

@Composable
fun AnswerButton(
    index: String,
    text: String,
    modifier: Modifier = Modifier,
    isSelect: Boolean = false
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = FinalOrangeApp,
            disabledContainerColor = Color.White
        ),
        shape = MaterialTheme.shapes.medium,
        enabled = isSelect,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
        border = if (isSelect) null else BorderStroke(2.dp, DisableGray),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .height(58.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = index,
                color = if (isSelect) Color.White else ContentGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = text,
                color = if (isSelect) Color.White else ContentGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun TestBodyPreview() {
    TTATheme {
        TestBody()
    }
}

@Preview(showBackground = true)
@Composable
private fun AnswerButtonPreview() {
    TTATheme {
        AnswerButton(index = "A)", text = "Muy poco")

    }
}