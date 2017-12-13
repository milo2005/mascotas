package org.unicauca.mascotas.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Mascota(val nombre:String,
              val raza:String,
              val fechaNacimiento: Date,
              val tipo:String,
              val sexo:String){

    @PrimaryKey(autoGenerate = true)
    var id:Long? = null



}