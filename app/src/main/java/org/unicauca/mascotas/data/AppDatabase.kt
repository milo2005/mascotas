package org.unicauca.mascotas.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota
import java.util.*


class Converter{
    @TypeConverter
    fun dateToLong(date:Date):Long = date.time

    @TypeConverter
    fun longToDate(long:Long):Date = Date(long)

}

@TypeConverters(Converter::class)
@Database(entities = [Mascota::class], version = 1)
abstract class AppDatabase:RoomDatabase(){

    abstract fun mascotaDao():MascotaDao

}