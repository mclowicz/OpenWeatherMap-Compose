package com.mclowicz.weatherapp.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mclowicz.weatherapp.R
import com.mclowicz.weatherapp.domain.model.WeatherResponse
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoilApi
@Composable
fun WeatherUI(
    weatherResponse: WeatherResponse
) {
    val details = weatherResponse.weather.first()
    val format = SimpleDateFormat("HH:mm")
    val painter = rememberImagePainter(
        data = "http://openweathermap.org/img/w/${details.icon}.png"
    ) {
        crossfade(1000)
        placeholder(R.drawable.bg_image)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Name component
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.primary)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = weatherResponse.name,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    color = MaterialTheme.colors.primary
                )
            }
        }
        // Details component
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.primary)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Text(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        text = "Details"
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Image(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .size(32.dp),
                        painter = painter,
                        contentDescription = "Weather Icon"
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = details.main
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = details.description
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Sunrise:"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Sunset:"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = format.format(Date(weatherResponse.sys.sunrise))
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = format.format(Date(weatherResponse.sys.sunset))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Pressure:"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Humidity:"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Temp min:"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Temp max:"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.main.pressure}"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.main.humidity}"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.main.tempMin}"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.main.tempMax}"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row() {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Lat:"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Long:"
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.coord.lat}"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            textAlign = TextAlign.Center,
                            text = "${weatherResponse.coord.lon}"
                        )
                    }
                }
            }
        }
    }
}