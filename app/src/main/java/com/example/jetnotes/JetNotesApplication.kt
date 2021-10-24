package com.example.jetnotes

import android.app.Application
import com.example.jetnotes.di.appModules
import di.dataModules
import di.domainModules
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@InternalCoroutinesApi
open class JetNotesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@JetNotesApplication)
            modules(provideModules())
        }
    }

    open fun provideModules() = appModules + domainModules + dataModules

}