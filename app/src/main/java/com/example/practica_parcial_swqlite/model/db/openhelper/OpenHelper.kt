package com.example.practica_parcial_swqlite.model.db.openhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.practica_parcial_swqlite.model.beans.Appearance
import com.example.practica_parcial_swqlite.model.beans.Biography
import com.example.practica_parcial_swqlite.model.beans.Hero
import com.example.practica_parcial_swqlite.model.beans.Image
import com.example.practica_parcial_swqlite.model.beans.PowerStats

class OpenHelper(context: Context): SQLiteOpenHelper(
    context, "heroes.db", null, 1
) {
    override fun onCreate(db: SQLiteDatabase?){
        val query = "create table heroes" +
                "(_ID integer primary key autoincrement," +
                "full_name text," +
                "gender text," +
                "race text," +
                "intelligence text," +
                "imageUrl text)"
        db?.execSQL(query)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        val query= "drop table heroes"
        db?.execSQL(query)
        onCreate(db)
    }

    fun readData(): MutableList<Hero>{
        val db = this.readableDatabase
        val query = "select * from heroes"
        val result = db.rawQuery(query, null)
        val heroList = mutableListOf<Hero>()

        if(result.moveToFirst()){
            do{
                heroList.add(
                    Hero(
                        result.getString(0),
                        biography = Biography(result.getString(1)),
                        appearance = Appearance(result.getString(2), result.getString(3)),
                        powerstats = PowerStats(result.getString(4)),
                        image = Image(result.getString(5))
                    )
                )
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return heroList
    }

    fun newHero(hero: Hero) {
        val datos = ContentValues()
        datos.put("full_name", hero.fullName)
        datos.put("gender", hero.gender)
        datos.put("race", hero.race)
        datos.put("intelligence", hero.intelligence)
        datos.put("imageUrl", hero.imageUrl)
    }

    fun deleteHero(id: Int) {
        val db = this.writableDatabase
        db.delete("heroes", "_ID=?", arrayOf(id.toString()))
        db.close()
    }
}
