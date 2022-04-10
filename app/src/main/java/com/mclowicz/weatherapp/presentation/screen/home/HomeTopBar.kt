package com.mclowicz.weatherapp.presentation.screen.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mclowicz.weatherapp.ui.theme.topAppBarBackgroundColor
import com.mclowicz.weatherapp.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Weather App",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar()
}