package com.example.tta.models

data class AttitudeTest(val questions: List<Question>)

data class Question(
    val id: String,
    val question: String,
    val answers: List<Answer>,

){
    companion object {
        val empty
            get() = Question("", "", emptyList())
    }
}

data class Answer(val id: String, val text: String)

data class UserAnswer(
    val questionId: String,
    val selectedAnswerId: String
)

fun getAttitudeTest(): AttitudeTest {
    val questions = listOf(
        Question(
            id = "1",
            question = "¿Con qué frecuencia te despiertas con mal humor?",
            answers = listOf(
                Answer(id = "a", text = "Casi todos los días"),
                Answer(id = "b", text = "Frecuentemente"),
                Answer(id = "c", text = "Raras veces"),
                Answer(id = "d", text = "Nunca")
            )
        ),
        Question(
            id = "2",
            question = "¿Con qué frecuencia un evento específico, (se me cayó la taza de café o me ensucié la ropa), cambia tu actitud del día y te irrita?",
            answers = listOf(
                Answer(id = "a", text = "Casi siempre"),
                Answer(id = "b", text = "Frecuentemente"),
                Answer(id = "c", text = "Raras veces"),
                Answer(id = "d", text = "Nunca")
            )
        ),
        Question(
            id = "3",
            question = "¿Qué tanta información chatarra, (noticias de ¿Tragedias o, farándula) consumes?",
            answers = listOf(
                Answer(id = "a", text = "Muchísima"),
                Answer(id = "b", text = "Bastante"),
                Answer(id = "c", text = "Poca"),
                Answer(id = "d", text = "Nada")
            )
        ),
        Question(
            id = "4",
            question = "¿Qué tan negativo es tu ambiente de trabajo?",
            answers = listOf(
                Answer(id = "a", text = "Demasiado negativo, quisiera no ir"),
                Answer(id = "b", text = "Un poco negativo, hay días en que no quisiera ir"),
                Answer(id = "c", text = "Positivo, es un ambiente agradable"),
                Answer(id = "d", text = "Muy positivo, me levanto entusiasmado para ir.")
            )
        ),
        Question(
            id = "5",
            question = "¿Qué tan tóxicas son tus amistades más cercanas?",
            answers = listOf(
                Answer(id = "a", text = "Muy tóxicos y criticones"),
                Answer(id = "b", text = "A veces negativos y hacen comentarios hirientes"),
                Answer(id = "c", text = "Neutros, no son negativos"),
                Answer(id = "d", text = "Felices, positivos y siempre tienen algo que aportarme")
            )
        ),
        Question(
            id = "6",
            question = "¿Con qué frecuencia te quejas o criticas algo o a alguien?",
            answers = listOf(
                Answer(id = "a", text = "Muy frecuente"),
                Answer(id = "b", text = "De vez en cuando, por algunas cosas específicas."),
                Answer(id = "c", text = "Poco probable, casi nunca me quejo o critico"),
                Answer(id = "d", text = "Nunca, no recuerdo la última vez que critique o me quejé por algo.")
            )
        ),
        Question(
            id = "7",
            question = "¿Qué tanto disfrutas lo que haces en tu trabajo, ocupación o negocio?",
            answers = listOf(
                Answer(id = "a", text = "Para nada, lo hago porque tengo que hacerlo"),
                Answer(id = "b", text = "Prefiero hacer otra cosa, pero lo tolero"),
                Answer(id = "c", text = "Me gusta y es llevadero"),
                Answer(id = "d", text = "Es mi pasión y propósito de vida.")
            )
        ),
        Question(
            id = "8",
            question = "¿Con qué frecuencia expresas tu gratitud a los demás, ya sea de manera verbal o con acciones?",
            answers = listOf(
                Answer(id = "a", text = "No soy expresivo para nada"),
                Answer(id = "b", text = "Digo gracias cuando es necesario"),
                Answer(id = "c", text = "Lo hago de vez en cuando, hasta con algún detalle."),
                Answer(id = "d", text = "Siempre tengo presente hacerle saber a los demás lo agradecido que estoy con ellos.")
            )
        ),
        Question(
            id = "9",
            question = "¿Qué tan frecuente te alimentas de información para tu crecimiento?",
            answers = listOf(
                Answer(id = "a", text = "No recuerdo la última vez que terminé un libro."),
                Answer(id = "b", text = "He asistido a alguna que otra conferencia y tengo algunos libros por leer en casa."),
                Answer(id = "c", text = "Leo frecuentemente pero aun no es un hábito"),
                Answer(id = "d", text = "Tengo agendada la lectura como parte de mi rutina diaria.")
            )
        ),
        Question(
            id = "10",
            question = "Cuando cometes un error ¿cómo son tus pensamientos hacia ti mismo?",
            answers = listOf(
                Answer(id = "a", text = "Soy demasiado duro conmigo mismo, a veces creo que soy mi peor enemigo."),
                Answer(id = "b", text = "Me culpo, pero luego se me pasa."),
                Answer(id = "c", text = "A veces me culpo, otras veces no."),
                Answer(id = "d", text = "Me hago responsable pero no me culpo, me perdono fácilmente.")
            )
        ),
        Question(
            id = "11",
            question = "¿Qué tanto te han dicho que tienes mala actitud?",
            answers = listOf(
                Answer(id = "a", text = "Muchas personas me han dicho que tengo una mala actitud."),
                Answer(id = "b", text = "Generalmente mis relacionados más cercanos dicen que tengo mala actitud."),
                Answer(id = "c", text = "Muy pocas veces realmente me han dicho eso."),
                Answer(id = "d", text = "Nunca me han recalcado que tengo mala actitud.")
            )
        ),
        Question(
            id = "12",
            question = "¿Qué tan frecuente se te presenta un conflicto o algún malentendido con alguien?",
            answers = listOf(
                Answer(id = "a", text = "Con honestidad, ahora mismo, casi diariamente."),
                Answer(id = "b", text = "Casi semanal tengo un conflicto con alguien"),
                Answer(id = "c", text = "Muy pocas veces, pero sí los he tenido."),
                Answer(id = "d", text = "No recuerdo el último conflicto que tuve con alguien.")
            )
        ),
        Question(
            id = "13",
            question = "Cuando se te presenta algún imprevisto ¿cómo reaccionas o respondes?",
            answers = listOf(
                Answer(id = "a", text = "Me paralizo porque no sé qué hacer, me quejo y me enojo."),
                Answer(id = "b", text = "Me molesta y me perturba temporalmente, pero luego pienso en qué hacer."),
                Answer(id = "c", text = "Me molesta un poco, pero fluyo."),
                Answer(id = "d", text = "Respiro profundo y empiezo a buscar una solución alterna.")
            )
        ),
        Question(
            id = "14",
            question = "¿Cuántas veces has ofendido a alguien en alguna conversación donde no hayas controlado tu enojo?",
            answers = listOf(
                Answer(id = "a", text = "Perdí la cuenta."),
                Answer(id = "b", text = "Bastante"),
                Answer(id = "c", text = "Unas cuantas"),
                Answer(id = "d", text = "Nunca he ofendido a alguien por un enojo mal manejado.")
            )
        ),
        Question(
            id = "15",
            question = "Cuando algún conocido logra un objetivo o una meta ¿qué tanto celebras ese logro?",
            answers = listOf(
                Answer(id = "a", text = "Desearía haber sido yo"),
                Answer(id = "b", text = "Me da igual, aunque no quiero que le vaya mal a nadie."),
                Answer(id = "c", text = "Realmente no lo hago, pero bien por él o ella."),
                Answer(id = "d", text = "Me alegro muchísimo y trato de hacérselo saber.")
            )
        ),
        Question(
            id = "16",
            question = "Cuando alguien te confronta y te dice que estás equivocado (a) ¿cómo es tu reacción o tu respuesta?",
            answers = listOf(
                Answer(id = "a", text = "Me molesto y me pongo a la defensiva, puede que termine en una discusión."),
                Answer(id = "b", text = "Me molesto pero igual escucho lo que tiene que decir"),
                Answer(id = "c", text = "Me siento confrontado pero igual escucho y trato de entender su punto de vista."),
                Answer(id = "d", text = "No me lo tomo personal y entiendo que puede estar en lo correcto.")
            )
        ),
        Question(
            id = "17",
            question = "¿Qué tanto caes en compararte con otros?",
            answers = listOf(
                Answer(id = "a", text = "Siempre lo hago de forma inconsciente"),
                Answer(id = "b", text = "Muy frecuente"),
                Answer(id = "c", text = "De vez en cuando lo hago, pero sin darme cuenta"),
                Answer(id = "d", text = "No me comparo, sé que cada quien tiene su proceso.")
            )
        ),
        Question(
            id = "18",
            question = "Cuando no obtienes los resultados que quieres, ¿qué tan responsable crees que eres de tus resultados?",
            answers = listOf(
                Answer(id = "a", text = "Sé que alguien no hizo lo que le correspondía y me tiene que dar las explicaciones de lugar."),
                Answer(id = "b", text = "Algo que no tomé en cuenta afectó el resultado."),
                Answer(id = "c", text = "Soy en parte responsable, así que debo cambiar; aunque si las cosas cambiaran o me ayudaran, fuera más fácil."),
                Answer(id = "d", text = "Soy total y absolutamente responsable de mis resultados independientemente de lo que pase.")
            )
        ),
        Question(
            id = "19",
            question = "¿Qué piensas sobre tener un mentor?",
            answers = listOf(
                Answer(id = "a", text = "Nunca he tenido uno y no creo que sirva para algo."),
                Answer(id = "b", text = "He escuchado que es importante, puede resultar"),
                Answer(id = "c", text = "He consultado algunas veces con alguien de confianza"),
                Answer(id = "d", text = "Tengo un mentor y le rindo cuentas frecuentemente.")
            )
        ),
        Question(
            id = "20",
            question = "¿Cuál es tu opinión con respecto al crecimiento espiritual para tener mejores resultados en la vida?",
            answers = listOf(
                Answer(id = "a", text = "Para mí nada de lo espiritual es relevante para tener resultados."),
                Answer(id = "b", text = "Sé que es importante, sin embargo no lo hago."),
                Answer(id = "c", text = "Hago un esfuerzo para crecer espiritualmente, simplemente a veces se me complica."),
                Answer(id = "d", text = "Es vital para mi vida y es parte fundamental de mis hábitos.")
            )
        )
    )

    return AttitudeTest(questions)
}