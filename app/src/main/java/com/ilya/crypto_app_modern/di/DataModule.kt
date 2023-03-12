package com.ilya.crypto_app_modern.di

import android.app.Application
import com.ilya.crypto_app_modern.data.database.AppDatabase
import com.ilya.crypto_app_modern.data.database.CoinInfoDao
import com.ilya.crypto_app_modern.data.repository.CoinRepositoryImpl
import com.ilya.crypto_app_modern.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {
        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}