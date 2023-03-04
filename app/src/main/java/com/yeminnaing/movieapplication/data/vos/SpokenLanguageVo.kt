package com.yeminnaing.movieapplication.data.vos

import com.google.gson.annotations.SerializedName

data class SpokenLanguageVo(
    @SerializedName("english_name")
    val englishName: String?,

    @SerializedName("iso_639_1")
    val iso_639_1:String?,

    @SerializedName("name")
    val name:String?
)
