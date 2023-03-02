package com.ilya.crypto_app_modern.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ilya.crypto_app_modern.pojo.CoinInfo

data class Datum (
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)
