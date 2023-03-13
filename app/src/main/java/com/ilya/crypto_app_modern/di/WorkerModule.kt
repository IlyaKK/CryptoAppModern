package com.ilya.crypto_app_modern.di

import com.ilya.crypto_app_modern.data.workers.ChildWorkerFactory
import com.ilya.crypto_app_modern.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(factory: RefreshDataWorker.Factory): ChildWorkerFactory
}