package org.unicauca.mascotas.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import org.unicauca.mascotas.data.DB
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota
import kotlin.concurrent.thread

class MainViewModel:ViewModel(){

    private val dao:MascotaDao = DB.con.mascotaDao()

    fun getAllMascotas():LiveData<List<Mascota>> = dao.all()

    fun deleteMascota(mascota:Mascota){
        thread{
            dao.delete(mascota)
        }
    }

}