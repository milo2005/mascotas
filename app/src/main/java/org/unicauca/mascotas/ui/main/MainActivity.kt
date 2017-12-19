package org.unicauca.mascotas.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_main.*
import org.unicauca.mascotas.R
import org.unicauca.mascotas.ui.adapters.MascotaAdapter
import org.unicauca.mascotas.ui.add.AddActivity
import org.unicauca.mascotas.util.LifeDisposable
import org.unicauca.mascotas.util.snackBarAction

class MainActivity : AppCompatActivity() {

    val adapter:MascotaAdapter = MascotaAdapter()
    lateinit var viewModel:MainViewModel
    val dis:LifeDisposable = LifeDisposable(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        list.adapter = adapter
    }


    override fun onResume() {
        super.onResume()
        dis add viewModel.getAllMascotas()
                .subscribe { adapter.data = it }

        dis add adapter.onDelete
                .flatMap(viewModel::deleteMascota)
                .flatMap { snackBarAction(root, R.string.deleted, R.string.action_restore, it) }
                .flatMap (viewModel::restoreMascota)
                .subscribe()

        dis add btnAdd.clicks()
                .subscribe {
                    val intent =  Intent(this, AddActivity::class.java)
                    startActivity(intent)
                }

    }

}
