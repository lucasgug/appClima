package com.lucasgugliuzza.clima.common.entities



data class WeatherForecastEntity(
    val timeZone: String,
    val current: Current,
    val hourly:List<Forecast>
    )
