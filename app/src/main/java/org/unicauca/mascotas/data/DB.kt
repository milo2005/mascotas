package org.unicauca.mascotas.data

import android.arch.persistence.room.Room
import android.content.Context

object DB{
    lateinit var con:AppDatabase

    fun init(context: Context){
        con = Room.databaseBuilder(context,AppDatabase::class.java, "mascotas.db")
                .fallbackToDestructiveMigration()
                .build()
    }

}