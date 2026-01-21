package com.example.netflixclone.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.netflixclone.R


data class Profile(
    val name: String,
    val avatarRes: Int,
    val isKids: Boolean = false
)

@Composable
fun ChooseProfileScreen(
    profiles: List<Profile> = defaultProfiles(),
    onProfileSelected: (Profile) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(R.drawable.lock),
                contentDescription = "Lock on",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 24.dp)
            )


            Text(
                text = "Profile Lock is on",
                fontSize = 18.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                text = "Who's watching?",
                fontSize = 28.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(profiles) { profile ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { onProfileSelected(profile) }
                    ) {
                        Image(
                            painter = painterResource(profile.avatarRes),
                            contentDescription = profile.name,
                            modifier = Modifier
                                .size(100.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(profile.name, color = Color.White, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

fun defaultProfiles() = listOf(
    Profile("Mind", R.drawable.avatar),
    Profile("Kids", R.drawable.avate, isKids = true),
    Profile("Add Profile", R.drawable.add)
)
