package com.example.learnnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnnavigation.ui.theme.LearnNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnNavigationTheme {
                val movieViewModel = viewModel<MovieViewModel>()
                AppNavigation(movieViewModel)
            }
        }
    }
}
