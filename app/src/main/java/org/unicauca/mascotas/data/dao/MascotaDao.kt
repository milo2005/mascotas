package org.unicauca.mascotas.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import org.unicauca.mascotas.data.model.Mascota

@Dao
interface MascotaDao{

    @Insert
    fun insert(mascota: Mascota)

    @Update
    fun update(mascota: Mascota)

    @Delete
    fun delete(mascota: Mascota)

    @Query("SELECT * FROM mascota")
    fun all():LiveData<List<Mascota>>

    @Query("SELECT * FROM mascota WHERE id = :id")
    fun mascotaById(id:Long):Mascota

}
