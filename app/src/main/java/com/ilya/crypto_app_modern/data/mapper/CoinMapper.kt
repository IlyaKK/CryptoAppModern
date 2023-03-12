package com.ilya.crypto_app_modern.data.mapper

import com.google.gson.Gson
import com.ilya.crypto_app_modern.data.database.CoinInfoDbModel
import com.ilya.crypto_app_modern.data.network.model.CoinInfoDto
import com.ilya.crypto_app_modern.data.network.model.CoinInfoJsonContainerDto
import com.ilya.crypto_app_modern.data.network.model.CoinNamesListDto
import com.ilya.crypto_app_modern.domain.CoinInfo
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapDtoToDbModel(coinInfoDto: CoinInfoDto) = CoinInfoDbModel(
        fromSymbol = coinInfoDto.fromSymbol,
        toSymbol = coinInfoDto.toSymbol,
        price = coinInfoDto.price,
        lastUpdate = coinInfoDto.lastUpdate,
        highDay = coinInfoDto.highDay,
        lowDay = coinInfoDto.lowDay,
        lastMarket = coinInfoDto.lastMarket,
        imageUrl = BASE_IMAGE_URL + coinInfoDto.imageUrl
    )

    fun mapJsonContainerToListCoinInfoDto(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.coinPriceInfoJsonObject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(coinNamesListDto: CoinNamesListDto): String {
        return coinNamesListDto.names?.map {
            it.coinNameDto?.name
        }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(coinInfoDbModel: CoinInfoDbModel) = CoinInfo(
        fromSymbol = coinInfoDbModel.fromSymbol,
        toSymbol = coinInfoDbModel.toSymbol,
        price = coinInfoDbModel.price,
        lastUpdate = convertTimestampToTime(coinInfoDbModel.lastUpdate),
        highDay = coinInfoDbModel.highDay,
        lowDay = coinInfoDbModel.lowDay,
        lastMarket = coinInfoDbModel.lastMarket,
        imageUrl = coinInfoDbModel.imageUrl
    )

    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    companion object {
        private const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}
