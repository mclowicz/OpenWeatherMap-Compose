package com.mclowicz.weatherapp.data.remote

import com.mclowicz.weatherapp.domain.model.WeatherResponse
import com.mclowicz.weatherapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun fetchWeatherByLatLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = API_KEY
    ): WeatherResponse
}