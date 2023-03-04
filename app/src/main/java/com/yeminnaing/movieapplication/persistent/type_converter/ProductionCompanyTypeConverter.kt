package com.yeminnaing.movieapplication.persistent.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeminnaing.movieapplication.data.vos.ProductionCompanyVo

class ProductionCompanyTypeConverter {


    @TypeConverter
    fun toString(productionCompanyVo: List<ProductionCompanyVo>?):String{
        return  Gson().toJson(productionCompanyVo);
    }

    @TypeConverter
    fun toProductionCompanyType(convertToProductionCompany:String):List<ProductionCompanyVo>?{
        val productionCompanyVoType=object : TypeToken<List<ProductionCompanyVo>?>(){}.type
        return  Gson().fromJson(convertToProductionCompany,productionCompanyVoType);
    }
}