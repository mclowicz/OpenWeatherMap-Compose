package com.mclowicz.weatherapp.data.repository

import com.mclowicz.weatherapp.data.remote.WeatherApi
import com.mclowicz.weatherapp.domain.model.WeatherResponse
import com.mclowicz.weatherapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): Repository {

    override suspend fun getWeatherByLatLon(lat: String, lon: String): WeatherResponse {
        return weatherApi.fetchWeatherByLatLon(lat = lat, lon = lon)
    }
}