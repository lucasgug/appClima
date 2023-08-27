package com.lucasgugliuzza.clima.common.adapter

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone") //PARA QUE PUEDA SER USADA DENTRO DE LA VISTA
fun bindIsGone(view: View, isGone :Boolean){
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}