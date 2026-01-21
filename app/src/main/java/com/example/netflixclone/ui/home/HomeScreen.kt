package com.example.netflixclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R
import com.example.netflixclone.ui.movie.MovieDetail
import com.example.netflixclone.ui.movie.MovieDetailPopup
import com.example.netflixclone.model.Movie

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    val selectedMovie = remember { mutableStateOf<MovieDetail?>(null) }
    val isPopupVisible = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 34.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.netflix),
                    contentDescription = "Netflix Logo",
                    modifier = Modifier.height(40.dp)
                )

                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(32.dp)
                )
            }

            sampleMovies().forEach { (category, movies) ->
                Text(
                    text = category,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    movies.forEach { movie ->
                        Image(
                            painter = painterResource(movie.thumbnailRes),
                            contentDescription = movie.title,
                            modifier = Modifier
                                .size(width = 120.dp, height = 180.dp)
                                .padding(end = 8.dp)
                                .clickable {
                                    selectedMovie.value = MovieDetail(
                                        title = movie.title,
                                        year = "2024",
                                        director = "John Doe",
                                        description = "This is a sample description for ${movie.title}.",
                                        thumbnailRes = movie.thumbnailRes
                                    )
                                    isPopupVisible.value = true
                                }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        selectedMovie.value?.let { movie ->
            MovieDetailPopup(movie = movie, isVisible = isPopupVisible)
        }
    }
}

fun sampleMovies(): Map<String, List<Movie>> {
    val dummyThumbnail = R.drawable.avatar
    return mapOf(
        "Trending Now" to listOf(
            Movie("Movie 1", dummyThumbnail),
            Movie("Movie 2", dummyThumbnail),
            Movie("Movie 3", dummyThumbnail)
        ),
        "Netflix Originals" to listOf(
            Movie("Movie 4", dummyThumbnail),
            Movie("Movie 5", dummyThumbnail),
            Movie("Movie 6", dummyThumbnail)
        )
    )
}
