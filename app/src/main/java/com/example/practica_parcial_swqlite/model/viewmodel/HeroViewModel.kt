package com.example.practica_parcial_swqlite.model.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_parcial_swqlite.model.beans.Hero
import com.example.practica_parcial_swqlite.model.client.RetrofitClient
import com.example.practica_parcial_swqlite.model.db.openhelper.OpenHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroViewModel (): ViewModel(){

    var heroesLists: MutableList<Hero> by mutableStateOf(arrayListOf())

    fun insertHero(context: Context, hero: Hero){
        var dbHelper = OpenHelper(context)
        dbHelper.newHero(hero)
    }

    fun getHeroesList(context: Context){
        var dbHelper = OpenHelper(context)
        heroesLists = dbHelper.readData()
    }

    fun deleteHero(context: Context, id: Int){
        var dbHelper = OpenHelper(context)
        dbHelper.deleteHero(id)
    }
}