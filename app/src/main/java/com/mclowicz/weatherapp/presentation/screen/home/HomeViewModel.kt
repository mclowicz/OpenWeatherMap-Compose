package com.mclowicz.weatherapp.presentation.screen.home

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mclowicz.weatherapp.domain.model.WeatherResponse
import com.mclowicz.weatherapp.domain.repository.Repository
import com.mclowicz.weatherapp.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _location: MutableStateFlow<Location?> = MutableStateFlow(null)
    val location = _location

    private var _weatherResponse: MutableStateFlow<RequestState<WeatherResponse>> =
        MutableStateFlow(RequestState.Idle)
    val weatherResponse = _weatherResponse

    fun setLocation(location: Location) {
        this._location.value = location
        requestWeather(location)
    }

    private fun requestWeather(location: Location) {
        _weatherResponse.value = RequestState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.getWeatherByLatLon(
                        lat = location.latitude.toString(),
                        lon = location.longitude.toString()
                    )
                }
                _weatherResponse.value = RequestState.Success(response)
            } catch (e: Exception) {
                _weatherResponse.value = RequestState.Error(e)
            }
        }
    }

    fun setNoLastLocation() {
        _weatherResponse.value = RequestState.Error(NoLastLocationException())
    }
}

class NoLastLocationException(
    override val message: String? = "No last known location."
) : Exception()