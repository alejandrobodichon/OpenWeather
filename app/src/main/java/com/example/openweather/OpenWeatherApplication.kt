package com.example.openweather

import ar.com.wolox.wolmo.core.WolmoApplication
import ar.com.wolox.wolmo.networking.di.DaggerNetworkingComponent
import ar.com.wolox.wolmo.networking.di.NetworkingComponent
import com.example.openweather.BaseConfiguration.SHARED_PREFERENCES_NAME
import com.example.openweather.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.FieldNamingPolicy
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.android.AndroidInjector
import okhttp3.logging.HttpLoggingInterceptor


class OpenWeatherApplication : WolmoApplication() {

    override fun onInit() {
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<OpenWeatherApplication> {
        return DaggerAppComponent.builder().networkingComponent(buildDaggerNetworkingComponent())
            .sharedPreferencesName(SHARED_PREFERENCES_NAME).application(this)
            .create(this)
    }

    private fun buildDaggerNetworkingComponent(): NetworkingComponent {
        val builder = DaggerNetworkingComponent.builder().baseUrl("https://api.openweathermap.org")
            .gsonNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        builder.okHttpInterceptors(buildHttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY), ChuckInterceptor(this))
        return builder.build()
    }

    private fun buildHttpLoggingInterceptor(
        level: HttpLoggingInterceptor.Level
    ): HttpLoggingInterceptor? {
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = level
        return loggerInterceptor
    }
}