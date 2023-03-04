package com.yeminnaing.movieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.yeminnaing.movieapplication.data.vos.DateVO
import com.yeminnaing.movieapplication.data.vos.MovieVO

data class MovieListResponse(
    @SerializedName("page")
    val page: Int?,

    @SerializedName("dates")
    val date: DateVO?,

    @SerializedName("results")
    val result: List<MovieVO>,
)