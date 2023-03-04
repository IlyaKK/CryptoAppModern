package com.ilya.crypto_app_modern.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ilya.crypto_app_modern.data.repository.CoinRepositoryImpl
import com.ilya.crypto_app_modern.domain.GetCoinInfoListUseCase
import com.ilya.crypto_app_modern.domain.GetCoinInfoUseCase
import com.ilya.crypto_app_modern.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()
    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}