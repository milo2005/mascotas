package org.unicauca.mascotas.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.unicauca.mascotas.data.DB
import org.unicauca.mascotas.data.dao.MascotaDao
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.util.applySchedulers
import kotlin.concurrent.thread

class MainViewModel:ViewModel(){

    private val dao:MascotaDao = DB.con.mascotaDao()

    fun getAllMascotas(): Flowable<List<Mascota>> = dao.all()
            .applySchedulers()


    fun deleteMascota(mascota:Mascota): Observable<Mascota> =
            Observable.fromCallable{ dao.delete(mascota)}
                    .map { mascota }
                    .applySchedulers()

    fun restoreMascota(mascota:Mascota): Observable<Unit> =
            Observable.fromCallable{
                dao.insert(mascota)
            }
                    .applySchedulers()


}