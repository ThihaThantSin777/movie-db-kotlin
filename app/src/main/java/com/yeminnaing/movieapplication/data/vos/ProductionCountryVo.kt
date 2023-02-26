package com.yeminnaing.movieapplication.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionCountryVo(
    @SerializedName("iso_3166_1")
    val iso_3166_1:String?,

    @SerializedName("name")
    val name:String?
)
