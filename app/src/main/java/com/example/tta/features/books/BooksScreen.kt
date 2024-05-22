package com.example.tta.features.books

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tta.R
import com.example.tta.models.Book
import com.example.tta.models.allBooks
import com.example.tta.ui.common.AppButton
import com.example.tta.ui.common.TTABackground
import com.example.tta.ui.common.TTANavBar
import com.example.tta.ui.theme.FinalOrangeApp
import com.example.tta.ui.theme.TTATheme

@Composable
fun BooksScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .size(56.dp),

                shape = MaterialTheme.shapes.extraLarge,
                onClick = { /*TODO*/ },
                containerColor = FinalOrangeApp
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_qr_scan),
                    contentDescription = null,
                )
            }
        },
        bottomBar = { TTANavBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BooksBody(allBooks)
        }
    }
}

@Composable
fun BooksBody(books: List<Book>, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        TTABackground(image = R.drawable.bg_main_blue)
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.libros),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(top = 68.dp, bottom = 32.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            LazyColumn(modifier = Modifier) {
                items(books.size) { book ->
                    BookCard(
                        cover = books.elementAt(book).cover,
                        title = books.elementAt(book).title,
                        author = books.elementAt(book).author
                    )
                }
            }

        }
    }

}

@Composable
fun BookCard(cover: Int, title: String, author: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(horizontal = 40.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = cover),
                contentDescription = null,
                modifier = Modifier
                    .height(130.dp)
                    .width(105.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .height(130.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = author, fontSize = 14.sp, color = Color.Gray)
                AppButton(
                    "COMPRAR",
                    modifier = Modifier.align(alignment = Alignment.End),
                    onClick = { /*TODO*/ })

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun BooksScreenPreview(modifier: Modifier = Modifier) {
    TTATheme {
        BooksScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun BookCardPreview(modifier: Modifier = Modifier) {
    TTATheme {
        BookCard(
            title = "Transforma tu actitud",
            author = "Enrique Canela",
            cover = R.drawable.img_book_1
        )
    }
}
