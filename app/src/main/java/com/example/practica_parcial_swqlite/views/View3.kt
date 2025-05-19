package com.example.practica_parcial_swqlite.views

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.practica_parcial_swqlite.model.beans.Hero
import com.example.practica_parcial_swqlite.model.viewmodel.HeroViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun View3(viewModel: HeroViewModel, context: Context, rememberScreen: NavHostController) {
    var heroList : MutableList<Hero> by mutableStateOf(arrayListOf())
    viewModel.getHeroesList(context)
    heroList = viewModel.heroesList

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tus Heroes Favoritos",
            fontSize = 40.sp,
            color = Color(0xFFFF0000),
            fontWeight = FontWeight.Bold
        )
        LazyColumn (
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(heroList){
                    hero ->(
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 5.dp),
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF8FCCFD)
                        )

                    ){
                        Column (
                            modifier = Modifier
                                .padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = hero.fullName + " " + hero.id)
                            GlideImage(
                                model = hero.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp)
                            )
                            Text(text = "Género: " + hero.gender)
                            Text(text = "Raza: " +  hero.race)
                            Text(text = "Inteligencia: " + hero.intelligence)
                            ElevatedButton(
                                colors = ButtonDefaults.buttonColors(Color(0xFF1A4E85)),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier,
                                onClick = {
                                    viewModel.deleteHero(context, hero.id.toInt())
                                    viewModel.getHeroesList(context)
                                }
                            ) {
                                Text(
                                    text = "Eliminar de favoritos", fontSize = 20.sp,
                                    color = Color.White, fontWeight = FontWeight.Bold
                                )

                            }
                        }
                    })
            }
        }
    }
}