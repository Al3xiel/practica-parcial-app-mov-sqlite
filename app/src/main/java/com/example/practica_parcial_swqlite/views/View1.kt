package com.example.practica_parcial_swqlite.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun View1(nav: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Comics App",
            fontSize = 50.sp,
            color = Color(0xFFFF0000),
            fontWeight = FontWeight.Bold
        )

        ElevatedButton(
            colors = ButtonDefaults.buttonColors(Color(0xFF1A4E85)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier,
            onClick = {
                nav.navigate("S2")
            }
        ) {
            Text(
                text = " Consulta de SuperHeroe por nombre", fontSize = 20.sp,
                color = Color.White, fontWeight = FontWeight.Bold
            )

        }
        ElevatedButton(
            colors = ButtonDefaults.buttonColors(Color(0xFF1A4E85)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier,
            onClick = {
                nav.navigate("S3")
            }
        ) {
            Text(
                text = "Listado de  SuperHeroes Favoritos", fontSize = 20.sp,
                color = Color.White, fontWeight = FontWeight.Bold
            )

        }
    }
}