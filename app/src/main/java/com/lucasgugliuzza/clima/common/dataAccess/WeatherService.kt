package com.lucasgugliuzza.clima.common.dataAccess

import com.lucasgugliuzza.clima.common.entities.WeatherForecastEntity
import com.lucasgugliuzza.clima.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherForecastByCoordinator(

        @Query(Constants.LATTITUDE_PARAM) lat:Double,
        @Query(Constants.LONGITUDE_PARAM) lon:Double,
        @Query(Constants.APP_ID_PARAM) appId:String,
        @Query(Constants.EXCLUDE_PARAM) exclude:String,
        @Query(Constants.UNITS_PARAM) units:String,
        @Query(Constants.LANGUAGE_PARAM) lang:String,



    ): WeatherForecastEntity

}