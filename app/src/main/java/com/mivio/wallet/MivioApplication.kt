package com.mivio.wallet

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MivioApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}