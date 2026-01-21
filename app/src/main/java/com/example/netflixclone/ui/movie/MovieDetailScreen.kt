package com.example.netflixclone.ui.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R

data class MovieDetail(
    val title: String,
    val year: String,
    val director: String,
    val description: String,
    val thumbnailRes: Int
)

@Composable
fun MovieDetailScreen(movie: MovieDetail, onShareClick: () -> Unit = {}) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(movie.thumbnailRes),
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = movie.title, color = Color.White, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Year: ${movie.year}  |  Director: ${movie.director}",
                color = Color.LightGray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.description,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onShareClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Share", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}
