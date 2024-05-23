package com.example.tta.features.tta_test

import androidx.lifecycle.ViewModel
import com.example.tta.models.Answer
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
        _viewStateFlow.update { it.copy(testState = TestState.InProgress(selectedQuestion = questions[0])) }
    }

    fun processEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.AnswerSelected -> {
                val answer = event.answer
                if (viewStateFlow.value.testState !is TestState.InProgress) return
                val state = viewStateFlow.value.testState as TestState.InProgress
                val question = state.selectedQuestion
                state.userAnswers.removeIf { it.questionId == question.id }
                val userAnswer = UserAnswer(
                    questionId = question.id,
                    selectedAnswerId = answer.id
                )
                if (state.currentQuestion == questions.size - 1) {
                    _viewStateFlow.update {
                        it.copy(
                            testState = TestState.Finished(
                                responses = state.userAnswers.apply { add(userAnswer) })
                        )
                    }
                } else {
                    when (state.halfwayMessage) {
                        HalfwayMessage.Shown -> {
                            _viewStateFlow.update {
                                it.copy(
                                    testState = it.testState.copy(
                                        currentQuestion = state.currentQuestion + 1,
                                        selectedQuestion = questions[state.currentQuestion + 1],
                                        userAnswers = state.userAnswers.apply { add(userAnswer) },
                                    )
                                )
                            }

                        }

                        HalfwayMessage.NotShown -> {
                            val showHalfwayMessage =
                                state.currentQuestion == 9 && state.halfwayMessage == HalfwayMessage.NotShown
                            _viewStateFlow.update { it ->
                                it.copy(
                                    testState = it.testState.copy(
                                        currentQuestion = state.currentQuestion + 1,
                                        selectedQuestion = questions[state.currentQuestion + 1],
                                        userAnswers = state.userAnswers.apply { add(userAnswer) },
                                        halfwayMessage = showHalfwayMessage.takeIf { it }
                                            ?.let { HalfwayMessage.Visible }
//                                            ?: HalfwayMessage.NotShown
                                    )
                                )
                            }

                        }

                        else -> {}
                    }

                }

            }

            ViewEvent.GoToPreviousQuestion -> {
                val state = viewStateFlow.value.testState as TestState.InProgress
                if (state.currentQuestion == 0) return
                _viewStateFlow.update {
                    it.copy(
                        testState = it.testState.copy(
                            currentQuestion = state.currentQuestion - 1,
                            selectedQuestion = questions[state.currentQuestion - 1]
                        )
                    )
                }
            }

            ViewEvent.ContinueFromHalfway -> {
                _viewStateFlow.update {
                    it.copy(
                        testState = it.testState.copy(
                            halfwayMessage = HalfwayMessage.Shown
                        )
                    )
                }
            }

            ViewEvent.ConsumeEffect -> _viewStateFlow.update { it.copy(viewEffect = null) }

        }
    }

    fun isAnswerSelected(answerId: String): Boolean {
        if (viewStateFlow.value.testState !is TestState.InProgress) return false
        val state = viewStateFlow.value.testState as TestState.InProgress
        val questionId = state.selectedQuestion.id
        return state.userAnswers.any { it.questionId == questionId && it.selectedAnswerId == answerId }
    }

    fun progress(): Float {
        if (questions.isEmpty()) return 0f
        if (viewStateFlow.value.testState !is TestState.InProgress) return 0f
        return if ((viewStateFlow.value.testState as TestState.InProgress).currentQuestion == 0) {
            0f
        } else {
            (viewStateFlow.value.testState as TestState.InProgress).currentQuestion.toFloat() / questions.size
        }
    }

    fun progressText(): String {
        return (progress() * 100).toInt().toString() + "%"
    }

}

data class ViewState(
    val isLoading: Boolean = true,
    val testState: TestState = TestState.InProgress(),
    val viewEffect: ViewEffect? = null
)

sealed interface ViewEffect {
    data object ShowHalfwayMessage : ViewEffect
}

sealed interface TestState {
    data class InProgress(
        val selectedQuestion: Question = Question.empty,
        val currentQuestion: Int = 0,
        val halfwayMessage: HalfwayMessage = HalfwayMessage.NotShown,
        val userAnswers: MutableList<UserAnswer> = mutableListOf(),
    ) : TestState

    data class Finished(
        val responses: List<UserAnswer> = emptyList(),
    ) : TestState


    fun copy(
        selectedQuestion: Question? = null,
        currentQuestion: Int? = null,
        userAnswers: MutableList<UserAnswer>? = null,
        halfwayMessage: HalfwayMessage? = null,

        ): TestState {
        return when (this) {
            is InProgress -> copy(
                selectedQuestion = selectedQuestion ?: this.selectedQuestion,
                userAnswers = userAnswers ?: this.userAnswers,
                currentQuestion = currentQuestion ?: this.currentQuestion,
                halfwayMessage = halfwayMessage ?: this.halfwayMessage,
            )

            is Finished -> throw IllegalAccessException("Finished state cannot be modified")
        }
    }

}

sealed interface ViewEvent {
    data object GoToPreviousQuestion : ViewEvent
    data object ContinueFromHalfway : ViewEvent
    data class AnswerSelected(val answer: Answer) : ViewEvent
    data object ConsumeEffect : ViewEvent
}

sealed interface HalfwayMessage {
    data object Shown : HalfwayMessage
    data object NotShown : HalfwayMessage
    data object Visible : HalfwayMessage
}