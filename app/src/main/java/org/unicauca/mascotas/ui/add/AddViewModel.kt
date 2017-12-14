package org.unicauca.mascotas.ui.add

import android.arch.lifecycle.ViewModel
import org.unicauca.mascotas.data.DB
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota
import kotlin.concurrent.thread

class AddViewModel:ViewModel(){

    val dao:MascotaDao = DB.con.mascotaDao()

    fun saveMascota(mascota: Mascota){
        thread{
            dao.insert(mascota)
        }
    }

}