package org.unicauca.mascotas.util

import android.databinding.BindingAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

@BindingAdapter("app:dateText")
fun setDateText(txt:TextView, date:Date) {
    txt.text = dateFormat.format(date)
}