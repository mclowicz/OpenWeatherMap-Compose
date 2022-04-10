package com.mclowicz.weatherapp.presentation.screen

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState
import com.mclowicz.weatherapp.presentation.screen.home.*
import com.mclowicz.weatherapp.util.openSettings

@ExperimentalCoilApi
@SuppressLint("MissingPermission")
@ExperimentalPermissionsApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val permissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_COARSE_LOCATION)
    var doNotShowMeRationale by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) {
        PermissionRequired(
            permissionState = permissionState,
            permissionNotGrantedContent = {
                if (doNotShowMeRationale) {
                    DoNotShowMeRationaleUI(context = context)
                } else {
                    PermissionNotGrantedUI(
                        onYesClick = { permissionState.launchPermissionRequest() },
                        onCancelClick = { doNotShowMeRationale = true })
                }
            },
            permissionNotAvailableContent = {
                PermissionNotAvailableContent(
                    onOpenSettingsClick = { context.openSettings() }
                )
            },
            content = {
                HomeContent(context = context)
            })
    }
}