package com.yeminnaing.movieapplication.persistent.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeminnaing.movieapplication.data.vos.GenreVo

class GenresVOTypeConverter {


    @TypeConverter
    fun toString(genresVO: List<GenreVo>?):String{
        return  Gson().toJson(genresVO);
    }

    @TypeConverter
    fun toGenreID(convertToGenresVO:String):List<GenreVo>?{
        val genreVOs=object : TypeToken<List<GenreVo>?>(){}.type
        return  Gson().fromJson(convertToGenresVO,genreVOs);
    }
}