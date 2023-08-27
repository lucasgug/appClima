package com.lucasgugliuzza.clima.mainModule.view.adapters

import com.lucasgugliuzza.clima.common.entities.Forecast

interface OnClickListener {

    fun onClick(forecast: Forecast)
}