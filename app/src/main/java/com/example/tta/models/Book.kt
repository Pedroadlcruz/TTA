package com.example.tta.models

import com.example.tta.R

data class Book(
    val id: Int,
    val title: String,
    val cover: Int,
    val author: String,
)
val allBooks: List<Book> =
    listOf(
        Book(
            id = 1,
            title = "Transforma tu actitud",
            cover = R.drawable.img_book_1,
            author = "Enrique Canela"
        ),
        Book(
            id = 2,
            title = "Fracasando hacia el éxito",
            cover = R.drawable.img_book_2,
            author = "Enrique & Inviertenti"
        ),
        Book( id = 3,
            title = "Lo que marca la diferencia",
            cover = R.drawable.img_book_3,
            author = "John Maxwell"),
        Book(
            id = 4,
            title = "Transforma tu actitud",
            cover = R.drawable.img_book_1,
            author = "Enrique Canela"
        ),
        Book(
            id = 5,
            title = "Fracasando hacia el éxito",
            cover = R.drawable.img_book_2,
            author = "Enrique & Inviertenti"
        ),
        Book( id = 6,
            title = "Lo que marca la diferencia",
            cover = R.drawable.img_book_3,
            author = "John Maxwell")
    );