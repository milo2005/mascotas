package org.unicauca.mascotas.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota

@Database(entities = [Mascota::class], version = 1)
abstract class AppDatabase:RoomDatabase(){

    abstract fun mascotaDao():MascotaDao

}