package com.yeminnaing.movieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.yeminnaing.movieapplication.data.vos.GenreVo

data class GetGenreResponse(
    @SerializedName("genres")
    val genres: List<GenreVo>,
)