package com.ahmad.aghazadeh.moviesta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ahmad.aghazadeh.moviesta.navigation.MovieNavigation
import com.ahmad.aghazadeh.moviesta.ui.theme.MoviestaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviestaTheme {
                MovieNavigation()
            }
        }
    }
}
