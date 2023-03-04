package com.yeminnaing.movieapplication.persistent.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeminnaing.movieapplication.data.vos.ProductionCountryVo
import com.yeminnaing.movieapplication.data.vos.SpokenLanguageVo

class SpokenLanguageTypeConverter {

    @TypeConverter
    fun toString(spokenLanguageVo: List<SpokenLanguageVo>?): String {
        return Gson().toJson(spokenLanguageVo);
    }

    @TypeConverter
    fun toSpokenLanguageType(convertSpokenLanguageVO: String): List<SpokenLanguageVo>? {
        val spokenLanguageVoType = object : TypeToken<List<SpokenLanguageVo>?>() {}.type
        return Gson().fromJson(convertSpokenLanguageVO, spokenLanguageVoType);
    }
}
