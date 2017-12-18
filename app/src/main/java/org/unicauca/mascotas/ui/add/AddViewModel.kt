package org.unicauca.mascotas.ui.add

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import org.unicauca.mascotas.data.DB
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.util.applySchedulers
import kotlin.concurrent.thread

class AddViewModel : ViewModel() {

    private val dao: MascotaDao = DB.con.mascotaDao()

    fun saveMascota(mascota: Mascota): Observable<Unit> =
            Observable.fromCallable { dao.insert(mascota) }
                    .applySchedulers()

}