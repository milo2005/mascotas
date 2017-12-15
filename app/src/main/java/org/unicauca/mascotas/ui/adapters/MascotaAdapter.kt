package org.unicauca.mascotas.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject
import org.unicauca.mascotas.R
import org.unicauca.mascotas.data.model.Mascota
import org.unicauca.mascotas.databinding.TemplateMascotaBinding

class MascotaAdapter:RecyclerView.Adapter<MascotaHolder>(){

    var data:List<Mascota> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    val onDelete:PublishSubject<Mascota> = PublishSubject.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_mascota,
                parent, false)
        return MascotaHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaHolder, position: Int) {
        holder.binding.mascota = data[position]
        holder.binding.onDelete = onDelete
    }

    override fun getItemCount(): Int = data.size

}

class MascotaHolder(view: View):RecyclerView.ViewHolder(view){
    val binding:TemplateMascotaBinding = DataBindingUtil.bind(view)
}