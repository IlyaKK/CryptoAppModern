package com.ilya.crypto_app_modern.presentation

import androidx.lifecycle.ViewModel
import com.ilya.crypto_app_modern.domain.GetCoinInfoListUseCase
import com.ilya.crypto_app_modern.domain.GetCoinInfoUseCase
import com.ilya.crypto_app_modern.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()
    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}