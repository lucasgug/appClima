package com.lucasgugliuzza.clima.common.entities

data class Forecast(

    val dt: Long,
    val humidty: Int,
    val temp: Double,
    val weather: List<Weather>,
    val pop :Double
) : WeatherBase(dt,humidty,temp,weather)

