package com.ilya.crypto_app_modern.domain

class LoadDataUseCase(private val repository: CoinRepository) {

    suspend operator fun invoke() = repository.loadData()
}