package com.mclowicz.weatherapp.domain.repository

import com.mclowicz.weatherapp.domain.model.WeatherResponse

interface Repository {
    suspend fun getWeatherByLatLon(lat: String, lon: String): WeatherResponse
}