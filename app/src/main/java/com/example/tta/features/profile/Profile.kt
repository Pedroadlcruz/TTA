package com.example.tta.features.profile

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tta.R
import com.example.tta.features.books.BookCard
import com.example.tta.models.Book
import com.example.tta.models.allBooks
import com.example.tta.ui.common.AppButton
import com.example.tta.ui.common.TTABackground
import com.example.tta.ui.common.TTANavBar
import com.example.tta.ui.theme.DarkBlue
import com.example.tta.ui.theme.DisableGray
import com.example.tta.ui.theme.FinalOrangeApp
import com.example.tta.ui.theme.TTATheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { TTANavBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileBody(modifier = modifier)
        }
    }
}

@Composable
fun ProfileBody(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.White)
    ) {
        TTABackground(image = R.drawable.bg_main_orange)
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.perfil),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(top = 68.dp, bottom = 12.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            ProfileCard()
            ResultCard()
            AppButton(
                text = "VER RESULTADOS DEL TEST",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .height(55.dp)
            )
//            BooksSlider(books = allBooks)
            RecommendedBooks()
        }
    }

}

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(90.dp)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(46.dp)
            )
            Column(modifier = Modifier) {
                Text(text = "Charlie Gomez Perez")
                Text(text = "charlie@gmail.com")
            }
        }
    }

}

@Composable
fun ResultCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.img_fox2), contentDescription = null)
            Image(painter = painterResource(id = R.drawable.img_fox), contentDescription = null)
            Image(
                painter = painterResource(id = R.drawable.img_fox),
                contentDescription = null,
                alpha = 0.3f
            )
            Image(
                painter = painterResource(id = R.drawable.img_fox),
                contentDescription = null,
                alpha = 0.3f
            )
            Image(
                painter = painterResource(id = R.drawable.img_fox),
                contentDescription = null,
                alpha = 0.3f
            )
        }
        LinearProgressIndicator(
            progress = 0.35f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .height(12.dp)
                .padding(horizontal = 16.dp),
            strokeCap = StrokeCap.Round
        )

        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            ) {
                Text(text = "Actitud actual:")
                Text(text = "Mala", fontWeight = FontWeight.Bold)
            }
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Actitud a lograr:")
                Text(text = "Extraordinaria", fontWeight = FontWeight.Bold)
            }
        }
    }

}

@Composable
fun BooksSlider(books: List<Book>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(books.size) { book ->
            BookCard(
                cover = books.elementAt(book).cover,
                title = books.elementAt(book).title,
                author = books.elementAt(book).author
            )
        }
    }
}

@Composable
fun RecommendedBooks(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(color = DisableGray)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Libros recomendados",
                fontWeight = FontWeight.W400,
                fontSize = 17.sp,
                color = DarkBlue
            )
            Text(
                text = "Ver más",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = FinalOrangeApp
            )
        }
        BooksSlider(books = allBooks, modifier = Modifier.padding(top = 24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 36.dp, end = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_top_arrow),
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "Te recomiendo elegir uno de los libros que te salió en el resultado del test e iniciar a leerlo.",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = DarkBlue
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    TTATheme {
        ProfileScreen()
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun ProfileBodyPreview(modifier: Modifier = Modifier) {
//    TTATheme { ProfileCard() }
//}

//@Preview(showBackground = true)
//@Composable
//private fun ResultCardPreview(modifier: Modifier = Modifier) {
//    TTATheme { ResultCard() }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun BooksSliderPreview(modifier: Modifier = Modifier) {
//    TTATheme { BooksSlider(books = allBooks) }
//}

@Preview(showBackground = true)
@Composable
private fun RecommendedBooksPreview() {
    TTATheme { RecommendedBooks() }
}