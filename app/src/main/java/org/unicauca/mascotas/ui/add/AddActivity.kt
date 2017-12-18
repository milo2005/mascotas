package org.unicauca.mascotas.ui.add

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.activity_add.*
import org.unicauca.mascotas.R
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.util.LifeDisposable
import org.unicauca.mascotas.util.text
import org.unicauca.mascotas.util.validateForm
import java.util.*

class AddActivity : AppCompatActivity() {

    lateinit var viewModel: AddViewModel
    val dis: LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        dis add btnGuardar.clicks()
                .flatMap { validateForm(R.string.form_err, nombre.text(), tipo.text(), raza.text()) }
                .flatMap {
                    viewModel.saveMascota(Mascota(it[0], it[2], Date(), it[1],
                            sexo.selectedItem.toString()))
                }.subscribe { finish() }
    }
}
