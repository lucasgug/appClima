package com.lucasgugliuzza.clima.mainModule.model

import com.lucasgugliuzza.clima.common.entities.WeatherForecastEntity

class MainRepository {
    private val remoteDatabase = RemoteDataBase()

    suspend fun getWeatherAndForecast(lat:Double ,lon:Double ,appId:String,
                                      units:String,lang:String
    ) : WeatherForecastEntity = remoteDatabase.getWeatherForecastByCoordinator(lat,lon,appId,
        units,lang)
}