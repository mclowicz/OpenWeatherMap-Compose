package com.mclowicz.weatherapp.di

import com.mclowicz.weatherapp.data.remote.WeatherApi
import com.mclowicz.weatherapp.data.repository.RepositoryImpl
import com.mclowicz.weatherapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        weatherApi: WeatherApi
    ): Repository {
        return RepositoryImpl(weatherApi = weatherApi)
    }
}