package com.example.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.example.netflixclone.ui.auth.LoginSignupScreen
import com.example.netflixclone.ui.splash.SplashScreen
import com.example.netflixclone.ui.theme.NetflixCloneTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netflixclone.ui.profile.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

                setContent {
                    NetflixCloneTheme {
                        val navController = rememberNavController()

                        NavHost(navController = navController, startDestination = "splash") {


                            composable("splash") {
                                SplashScreen()
                                LaunchedEffect(Unit) {
                                    kotlinx.coroutines.delay(2000)
                                    navController.navigate("login") {
                                        popUpTo("splash") { inclusive = true }
                                    }
                                }
                            }
                            composable("login") {
                                LoginSignupScreen(
                                    onLoginClick = { navController.navigate("profile") },
                                    onSignupClick = { navController.navigate("profile") }
                                )
                            }


                            composable("profile") {
                                ProfileScreen()
                            }
                        }
                    }
                }

    }
}
