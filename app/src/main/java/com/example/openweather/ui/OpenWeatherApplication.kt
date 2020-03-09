package com.example.openweather.ui

import android.app.Application
import com.example.openweather.ui.BaseConfiguration.SHARED_PREFERENCES_NAME
import com.google.gson.FieldNamingPolicy
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.android.AndroidInjector
import okhttp3.logging.HttpLoggingInterceptor


class OpenWeatherApplication : Application() {

//    private lateinit var applicationComponent: ApplicationComponent
//
//
//    override fun onCreate() {
//        super.onCreate()
//        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
//        applicationComponent.injectApplication(this);
//    }



//    override fun applicationInjector(): AndroidInjector<OpenWeatherApplication> {
//        return DaggerAppComponent.builder().networkingComponent(buildDaggerNetworkingComponent())
//            .sharedPreferencesName(SHARED_PREFERENCES_NAME).application(this)
//            .create(this)
//    }



//    private fun buildDaggerNetworkingComponent(): NetworkingComponent {
//        val builder = DaggerNetworkingComponent.builder().baseUrl("https://api.mercadopago.com/")
//            .gsonNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//        builder.okHttpInterceptors(buildHttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY), ChuckInterceptor(this))
//        return builder.build()
//    }

    private fun buildHttpLoggingInterceptor(
        level: HttpLoggingInterceptor.Level
    ): HttpLoggingInterceptor? {
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = level
        return loggerInterceptor
    }
}