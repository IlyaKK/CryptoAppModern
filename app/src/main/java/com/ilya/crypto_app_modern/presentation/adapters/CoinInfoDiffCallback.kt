package com.ilya.crypto_app_modern.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ilya.crypto_app_modern.domain.CoinInfo

object CoinInfoDiffCallback:DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}