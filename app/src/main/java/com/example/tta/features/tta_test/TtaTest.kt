package com.example.tta.features.tta_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tta.R
import com.example.tta.models.Question
import com.example.tta.ui.common.AppButton
import com.example.tta.ui.theme.BgGray
import com.example.tta.ui.theme.ContentGray
import com.example.tta.ui.theme.DarkBlue
import com.example.tta.ui.theme.DisableGray
import com.example.tta.ui.theme.FinalOrangeApp
import com.example.tta.ui.theme.SuccessGreen
import com.example.tta.ui.theme.TTADarkGray
import com.example.tta.ui.theme.TTATheme
import com.example.tta.utils.compositionLocals.DisabledRippleThemeColorAndAlpha

@Composable
fun TtaTestScreen(modifier: Modifier = Modifier, ttaTestViewModel: TtaTestViewModel = viewModel()) {
    val ttaTestViewState by ttaTestViewModel.viewStateFlow.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (val testState = ttaTestViewState.testState) {
                is TestState.InProgress -> {
                    if (testState.halfwayMessage == HalfwayMessage.Visible) {
                        TtaTestMessage(
                            onButtonClicked = {
                                ttaTestViewModel.processEvent(ViewEvent.ContinueFromHalfway)
                            })
                    } else {
                        TestBody(
                            question = testState.selectedQuestion,
                            progress = ttaTestViewModel.progress(),
                            progressText = ttaTestViewModel.progressText(),
                            onEvent = ttaTestViewModel::processEvent,
                            isAnswerSelected = ttaTestViewModel::isAnswerSelected
                        )
                    }
                }

                is TestState.Finished -> {
                    TtaTestMessage(
                        title = "¡Completado!",
                        message = "¡Toma la iniciativa de conocer la mejor versión de ti!",
                        image = R.drawable.img_test_completado,
                        buttonText = "Ver mi resultado",
                        onButtonClicked = {
//                            ttaTestViewModel.processEvent(ViewEvent.GoToNextQuestion)
                        })
                }

            }
            val context = LocalContext.current
            LaunchedEffect(ttaTestViewState.viewEffect) {
                ttaTestViewState.viewEffect?.let { viewEffect ->
                    when (viewEffect) {
                        ViewEffect.ShowHalfwayMessage -> {
                            // TODO
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun TtaTestMessage(
    modifier: Modifier = Modifier,
    title: String = "¡Vas bien!",
    message: String = "¡Casi terminas!",
    buttonText: String = "Continuar",
    image: Int = R.drawable.img_vas_bien,
    onButtonClicked: () -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Test de la actitud", fontWeight = FontWeight.W600,
                fontSize = 17.sp,
                lineHeight = 20.72.sp,
                color = DarkBlue, modifier = Modifier.padding(top = 48.dp)
            )
        }
        item {
            Text(
                text = title, fontWeight = FontWeight.W600,
                fontSize = 40.sp,
                lineHeight = 20.72.sp,
                color = DarkBlue, modifier = Modifier.padding(top = 20.dp)
            )
        }
        item {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 72.dp, bottom = 72.dp)
                    .background(Color.White)
            )
        }
        item {
            Text(
                text = message,
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                lineHeight = 20.72.sp,
                textAlign = TextAlign.Center,
                color = DarkBlue,
                modifier = Modifier.padding(top = 20.dp, start = 48.dp, end = 48.dp)
            )
        }
        item {
            AppButton(
                text = buttonText,
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, top = 40.dp, bottom = 16.dp)
                    .height(55.dp),
                onClick = onButtonClicked

            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestBody(
    modifier: Modifier = Modifier,
    question: Question,
    progress: Float,
    progressText: String,
    onEvent: (ViewEvent) -> Unit,
    isAnswerSelected: (answerId: String) -> Boolean,
) {
    LazyColumn(
        modifier = modifier
            .background(BgGray)
            .fillMaxSize()
            .padding(horizontal = 24.dp)


    ) {
        item { Header(onEvent, progressText) }
        item {
            LinearProgressIndicator(
                progress = progress,
                color = SuccessGreen,
                trackColor = DisableGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp, top = 24.dp)
                    .height(12.dp),
                strokeCap = StrokeCap.Round
            )
        }
        item {
            Text(
                text = question.question,
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                lineHeight = 28.38.sp,
                color = TTADarkGray,
                modifier = Modifier.padding(bottom = 40.dp, top = 16.dp)
            )
        }
        items(question.answers.size, key = { index -> question.answers[index].id }) { index ->
            val answer = question.answers[index]
            AnswerButton(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .animateItemPlacement(),
                index = "${index + 1})",
                text = answer.text,
                onAnswerClick = { onEvent(ViewEvent.AnswerSelected(answer)) },
                isSelect = isAnswerSelected(answer.id)
            )
        }


    }
}

@Composable
private fun Header(
    onEvent: (ViewEvent) -> Unit,
    progressText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onEvent(ViewEvent.GoToPreviousQuestion) },
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
            text = progressText,
            fontWeight = FontWeight.W600,
            fontSize = 17.sp,
            lineHeight = 20.72.sp,
            color = Color.Black
        )
    }
}

@Composable
fun AnswerButton(
    index: String,
    text: String,
    modifier: Modifier = Modifier,
    isSelect: Boolean = false,
    onAnswerClick: () -> Unit
) {
    CompositionLocalProvider(LocalRippleTheme provides DisabledRippleThemeColorAndAlpha) {
        Button(
            onClick = onAnswerClick,
            colors = if (isSelect) ButtonDefaults.buttonColors(containerColor = FinalOrangeApp) else
                ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = MaterialTheme.shapes.medium,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            border = if (isSelect) null else BorderStroke(2.dp, DisableGray),
            modifier = modifier

                .fillMaxWidth()
                .padding(bottom = 20.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = index,
                    color = if (isSelect) Color.White else ContentGray,
                    fontSize = 18.sp,
                    fontWeight = if (isSelect) FontWeight.Bold else FontWeight.W400,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = text,
                    color = if (isSelect) Color.White else ContentGray,
                    fontSize = 18.sp,
                    fontWeight = if (isSelect) FontWeight.Bold else FontWeight.W400
                )
            }

        }
    }

}


//@Preview(showBackground = true)
//@Composable
//private fun TestBodyPreview() {
//    TTATheme {
//        TestBody(
//            question = Question(
//                id = "1",
//                question = "¿Con qué frecuencia te despiertas con mal humor?",
//                answers = listOf(
//                    Answer(id = "a", text = "Casi todos los días"),
//                    Answer(id = "b", text = "Frecuentemente"),
//                    Answer(id = "c", text = "Raras veces"),
//                    Answer(id = "d", text = "Nunca")
//                )
//            )
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun AnswerButtonPreview() {
//    TTATheme {
//        AnswerButton(index = "A)", text = "Muy poco")
//
//    }
//}
//
@Preview(showBackground = true)
@Composable
private fun TtaTestScreenPreview() {
    TTATheme {
        TtaTestScreen()
    }

}

@Preview(showBackground = true)
@Composable
private fun HalfwayMessagePreview() {
    TTATheme {
        TtaTestMessage(onButtonClicked = {})
    }

}