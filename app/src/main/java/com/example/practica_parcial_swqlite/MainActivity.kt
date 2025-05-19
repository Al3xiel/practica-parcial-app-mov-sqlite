package com.example.practica_parcial_swqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.practica_parcial_swqlite.model.viewmodel.HeroViewModel
import com.example.practica_parcial_swqlite.ui.theme.PracticaparcialswqliteTheme
import com.example.practica_parcial_swqlite.views.nav.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel by viewModels<HeroViewModel>()
        setContent {
            PracticaparcialswqliteTheme {
               Navigation(viewModel, this)
            }
        }
    }
}
