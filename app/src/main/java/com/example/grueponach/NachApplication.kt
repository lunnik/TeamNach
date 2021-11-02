package com.example.grueponach

import android.app.Application
import android.content.IntentFilter
import com.example.grueponach.di.initKoin
import com.example.grueponach.system.broadcast_receiver.ConnectivityReceiver
import timber.log.Timber

class NachApplication : Application() {

    companion object {
        fun getInstance() = NachApplication()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        initKoin()
        initBroadcastReceiver()
    }

    /**
     *
     */
    private fun initBroadcastReceiver() {
        registerReceiver(
            ConnectivityReceiver(),
            IntentFilter(ConnectivityReceiver.connectivityChangeInputFilter)
        )
    }

}