package com.example.practica_parcial_swqlite.views.nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica_parcial_swqlite.model.viewmodel.HeroViewModel
import com.example.practica_parcial_swqlite.views.View1
import com.example.practica_parcial_swqlite.views.View2
import com.example.practica_parcial_swqlite.views.View3

@Composable
fun Navigation (viewModel: HeroViewModel, context: Context){
    val rememberScreen= rememberNavController()
    NavHost(navController=rememberScreen, startDestination="S1") {
        composable("S1") { View1(rememberScreen) }
        composable("S2"){ View2(viewModel, context, rememberScreen) }
        composable("S3") { View3(viewModel, context, rememberScreen) }
    }
}