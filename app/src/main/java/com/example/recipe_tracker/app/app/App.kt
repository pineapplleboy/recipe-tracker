package com.example.recipe_tracker.app.app

import android.app.Application
import com.example.recipe_tracker.app.di.appModule
import com.example.recipe_tracker.app.di.dataModule
import com.example.recipe_tracker.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}