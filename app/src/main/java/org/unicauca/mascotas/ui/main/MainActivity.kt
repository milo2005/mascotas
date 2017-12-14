package org.unicauca.mascotas.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.unicauca.mascotas.R
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.ui.adapters.MascotaAdapter
import org.unicauca.mascotas.ui.add.AddActivity

class MainActivity : AppCompatActivity() {

    val adapter:MascotaAdapter = MascotaAdapter()
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        list.adapter = adapter

        viewModel.getAllMascotas().observe(this, Observer {
            adapter.data = it!!
        })

        adapter.onDeleteMascota = this::deleteMascota

        btnAdd.setOnClickListener{
            val intent =  Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    fun deleteMascota(mascota: Mascota){
        viewModel.deleteMascota(mascota)
    }
}
