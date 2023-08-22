package com.lucasgugliuzza.clima.mainModule.model

import com.lucasgugliuzza.clima.common.dataAccess.WeatherService
import com.lucasgugliuzza.clima.common.entities.WeatherForecastEntity
import com.lucasgugliuzza.clima.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataBase {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val service = retrofit.create(WeatherService::class.java)

    suspend fun getWeatherForecastByCoordinator(lat:Double ,lon:Double ,appId:String,
            units:String,lang:String
    ): WeatherForecastEntity = withContext(Dispatchers.IO) {
        service.getWeatherForecastByCoordinator(lat,lon,appId,units,lang)
    }
}