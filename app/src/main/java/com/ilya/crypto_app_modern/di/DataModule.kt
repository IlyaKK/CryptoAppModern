package com.ilya.crypto_app_modern.di

import android.app.Application
import com.ilya.crypto_app_modern.data.database.AppDatabase
import com.ilya.crypto_app_modern.data.database.CoinInfoDao
import com.ilya.crypto_app_modern.data.network.ApiFactory
import com.ilya.crypto_app_modern.data.network.ApiService
import com.ilya.crypto_app_modern.data.repository.CoinRepositoryImpl
import com.ilya.crypto_app_modern.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}