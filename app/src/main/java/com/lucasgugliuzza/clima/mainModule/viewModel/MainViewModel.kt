package com.lucasgugliuzza.clima.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasgugliuzza.clima.R
import com.lucasgugliuzza.clima.common.entities.WeatherForecastEntity
import com.lucasgugliuzza.clima.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repositoty = MainRepository()

    private val result = MutableLiveData<WeatherForecastEntity>()
    fun getResult() : LiveData<WeatherForecastEntity> = result


    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackMsg() = snackbarMsg

    private val loaded = MutableLiveData<Boolean>()
    fun isLoaded() = loaded

    suspend fun getWeatherAndForecast(lat:Double ,lon:Double ,appId:String,exclude:String,
                                                  units:String,lang:String) {
        viewModelScope.launch {
           try {
               loaded.value = false //activa la barra de carga
               val resultServer = repositoty.getWeatherAndForecast(lat, lon, appId, units, lang ,exclude)
               result.value = resultServer
               if (resultServer.hourly == null || resultServer.hourly.isEmpty())
                   snackbarMsg.value = R.string.main_error_empty_forecast
           } catch (e : Exception){
               snackbarMsg.value = R.string.main_error_server
           }finally {
                loaded.value =  true //oculta la barra de carga
           }
        }

    }

}