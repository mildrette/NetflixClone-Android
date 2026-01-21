package com.example.netflixclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.netflixclone.ui.auth.LoginSignupScreen

import com.example.netflixclone.ui.splash.SplashScreen
import com.example.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixCloneTheme {
//                SplashScreen()
//                LoginScreen()
                LoginSignupScreen()
            }
        }
    }
}
