package com.ilya.crypto_app_modern.di

import android.app.Application
import com.ilya.crypto_app_modern.presentation.CoinApp
import com.ilya.crypto_app_modern.presentation.CoinDetailFragment
import com.ilya.crypto_app_modern.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(coinPriceListActivity: CoinPriceListActivity)

    fun inject(coinDetailFragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}