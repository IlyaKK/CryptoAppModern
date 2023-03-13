package com.ilya.crypto_app_modern.presentation

import android.app.Application
import androidx.work.Configuration
import com.ilya.crypto_app_modern.data.database.AppDatabase
import com.ilya.crypto_app_modern.data.mapper.CoinMapper
import com.ilya.crypto_app_modern.data.network.ApiFactory
import com.ilya.crypto_app_modern.data.workers.RefreshDataWorkerFactory
import com.ilya.crypto_app_modern.di.DaggerApplicationComponent

class CoinApp : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(
                RefreshDataWorkerFactory(
                    AppDatabase.getInstance(this).coinPriceInfoDao(),
                    ApiFactory.apiService,
                    CoinMapper()
                )
            )
            .build()
    }
}