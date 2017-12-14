package org.unicauca.mascotas.ui.add

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import org.unicauca.mascotas.R
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.util.text
import java.util.*

class AddActivity : AppCompatActivity() {

    lateinit var viewModel:AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)

        btnGuardar.setOnClickListener{
            val nom = nombre.text()
            val tip = tipo.text()
            val raz = raza.text()
            val sex = sexo.selectedItem.toString()

            viewModel.saveMascota(Mascota(nom, raz, Date(), tip, sex))
            finish()
        }
    }
}
