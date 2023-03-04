package com.yeminnaing.movieapplication.data.vos

import com.google.gson.annotations.SerializedName

data class GenreVo(
    @SerializedName("id")
   val  id :Int?,
    @SerializedName("name")
   val name:String?
)