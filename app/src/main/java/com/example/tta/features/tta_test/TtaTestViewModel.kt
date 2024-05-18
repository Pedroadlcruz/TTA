package com.example.tta.features.tta_test

import androidx.lifecycle.ViewModel
import com.example.tta.models.Question
import com.example.tta.models.UserAnswer
import com.example.tta.models.getAttitudeTest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TtaTestViewModel : ViewModel() {

    private val _viewStateFlow: MutableStateFlow<ViewState> = MutableStateFlow(ViewState())
    val viewStateFlow: StateFlow<ViewState> = _viewStateFlow.asStateFlow()
    private val questions = mutableListOf<Question>()

    init {
        val test = getAttitudeTest()
        questions.addAll(test.questions)
        _viewStateFlow.update { it.copy(selectedQuestion = questions[0]) }
    }

    fun onAnswerSelected(answerId: String) {
        if (viewStateFlow.value.selectedQuestion == null) return
        viewStateFlow.value.userAnswers.removeIf { it.questionId == viewStateFlow.value.selectedQuestion!!.id }
        val userAnswer = UserAnswer(
            questionId = viewStateFlow.value.selectedQuestion!!.id,
            selectedAnswerId = answerId
        )
        _viewStateFlow.update {
            it.copy(
                userAnswers = it.userAnswers.apply { add(userAnswer) },
                currentQuestion = it.currentQuestion + 1,
                selectedQuestion = questions[it.currentQuestion + 1]
            )
        }
    }

    fun isAnswerSelected(answerId: String, questionId: String): Boolean {
        return viewStateFlow.value.userAnswers.any { it.questionId == questionId && it.selectedAnswerId == answerId }
    }

    fun previousQuestion() {
        if (viewStateFlow.value.currentQuestion == 0) return
        _viewStateFlow.update {
            it.copy(
                currentQuestion = it.currentQuestion - 1,
                selectedQuestion = questions[it.currentQuestion - 1]
            )
        }
    }

    fun progress(): Float {
        return if (viewStateFlow.value.currentQuestion == 0) {
            0f
        } else {
            viewStateFlow.value.currentQuestion.toFloat() / questions.size
        }
    }

    fun progressText(): String {
        return (progress() * 100).toInt().toString() + "%"
    }


    fun gotHalfway() {
        _viewStateFlow.update { it.copy(gotHalfway = true) }
    }

    fun gotAll() {
        _viewStateFlow.update { it.copy(gotAll = true) }
    }

}

data class ViewState(
    val currentQuestion: Int = 0,
    val gotHalfway: Boolean = false,
    val gotAll: Boolean = false,
    val userAnswers: MutableList<UserAnswer> = mutableListOf(),
    val selectedQuestion: Question? = null,
)
