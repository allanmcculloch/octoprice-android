package com.octoprice.android

import android.app.Application
import com.octoprice.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OctoPriceApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@OctoPriceApplication)
            modules(appModule)
        }
    }
}