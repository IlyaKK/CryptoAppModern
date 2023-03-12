package com.ilya.crypto_app_modern.presentation

import android.app.Application
import com.ilya.crypto_app_modern.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}