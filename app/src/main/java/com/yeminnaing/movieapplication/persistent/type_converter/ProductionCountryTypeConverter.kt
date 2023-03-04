package com.yeminnaing.movieapplication.persistent.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeminnaing.movieapplication.data.vos.ProductionCompanyVo
import com.yeminnaing.movieapplication.data.vos.ProductionCountryVo

class ProductionCountryTypeConverter {

    @TypeConverter
    fun toString(productionCountryVo: List<ProductionCountryVo>?): String {
        return Gson().toJson(productionCountryVo);
    }

    @TypeConverter
    fun toProductionCountryType(convertToProductionCountry: String): List<ProductionCountryVo>? {
        val productionCountryVoType = object : TypeToken<List<ProductionCountryVo>?>() {}.type
        return Gson().fromJson(convertToProductionCountry, productionCountryVoType);
    }
}