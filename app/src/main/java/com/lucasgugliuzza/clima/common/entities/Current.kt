package com.lucasgugliuzza.clima.common.entities

data class Current(
   val dt: Long,
   val humidty: Int,
   val temp: Double,
   val weather: List<Weather>,
   val sunrise :Long
) : WeatherBase(dt,humidty,temp,weather)
