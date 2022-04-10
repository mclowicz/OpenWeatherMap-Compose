package com.mclowicz.weatherapp.presentation.screen.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.google.android.gms.location.LocationServices
import com.mclowicz.weatherapp.component.common.ErrorUI
import com.mclowicz.weatherapp.component.common.LoadingUI
import com.mclowicz.weatherapp.util.RequestState

@ExperimentalCoilApi
@SuppressLint("MissingPermission")
@Composable
fun HomeContent(
    context: Context,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val location = homeViewModel.location.collectAsState().value
    val weatherResponse = homeViewModel.weatherResponse.collectAsState().value
    LocationServices.getFusedLocationProviderClient(context).apply {
        lastLocation.addOnSuccessListener { lastKnown ->
            if (location == null) {
                lastKnown?.let {
                    homeViewModel.setLocation(it)
                }
                if (lastKnown == null) {
                    // No last known location message
                    homeViewModel.setNoLastLocation()
                }
            }
        }
    }
    when (weatherResponse) {
        is RequestState.Error -> {
            ErrorUI(weatherResponse.t)
        }
        is RequestState.Success -> {
            WeatherUI(weatherResponse = weatherResponse.data)
        }
        is RequestState.Loading, is RequestState.Idle -> {
            LoadingUI()
        }
    }
}