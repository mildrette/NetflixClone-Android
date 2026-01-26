package com.example.netflixclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color.Black,
        topBar = { NetflixTopBar() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.Black)
        ) {

            item { CategorySelector() }
            item { HeroCarousel() }

            item { MovieRow("Continue Watching") }
            item { MovieRow("Because You Watched") }
            item { MovieRow("Only on Netflix") }
            item { MovieRow("Trending Now") }
            item { MovieRow("My List") }
            item { MovieRow("Watch Again") }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetflixTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
        title = {
            Image(
                painter = painterResource(R.drawable.netflix),
                contentDescription = "Netflix",
                modifier = Modifier.height(32.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Download,
                contentDescription = "Downloads",
                tint = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
            Image(
                painter = painterResource(R.drawable.avate),
                contentDescription = "Profile",
                modifier = Modifier.size(32.dp)
            )
        }
    )
}


@Composable
fun CategorySelector() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("TV Shows", color = Color.White)
        Text("Movies", color = Color.White)
        Text("Categories ▼", color = Color.White)
    }
}

@Composable
fun HeroCarousel() {
    val pagerState = rememberPagerState(pageCount = { 3 })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) { page ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Featured Movie Title",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text("Play", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    OutlinedButton(onClick = {}) {
                        Text("My List", color = Color.White)
                    }
                }
            }
        }
    }
}


@Composable
fun MovieRow(title: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(10) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .width(120.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable { }
                )
            }
        }
    }
}
