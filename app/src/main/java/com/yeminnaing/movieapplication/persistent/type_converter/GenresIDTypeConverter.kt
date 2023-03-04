package com.yeminnaing.movieapplication.persistent.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenresIDTypeConverter {

    @TypeConverter
    fun toString(genreIDs: List<Int>?):String{
        return  Gson().toJson(genreIDs);
    }

    @TypeConverter
    fun toGenreID(convertToGenresID:String):List<Int>?{
        val genreIDs=object :TypeToken<List<Int>?>(){}.type
        return  Gson().fromJson(convertToGenresID,genreIDs);
    }
}