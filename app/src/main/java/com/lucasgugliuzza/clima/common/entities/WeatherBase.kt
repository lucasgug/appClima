package com.lucasgugliuzza.clima.common.entities

open class WeatherBase(
    dt: Long,
    humidity: Int,
    temp: Double,
    weather: List<Weather>
)