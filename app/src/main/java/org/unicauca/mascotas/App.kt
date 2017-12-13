package org.unicauca.mascotas

import android.app.Application
import org.unicauca.mascotas.data.DB

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        DB.init(this)
    }
}