package com.mclowicz.weatherapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.lang.Exception

@Serializable
data class WeatherResponse(
    val name: String,
    val coord: Coord,
    val weather: List<Weather>,
    val sys: Sys,
    val main: Main,
    @Transient
    val error: Exception? = null
)

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double
)

@Serializable
data class Weather(
    val main: String,
    val description: String,
    val icon: String
)

@Serializable
data class Sys(
    val sunrise: Long,
    val sunset: Long
)

@Serializable
data class Main(
    val pressure: Int,
    val humidity: Int,
    @SerialName("temp_min")
    val tempMin: Double?,
    @SerialName("temp_max")
    val tempMax: Double?
)
