package com.yeminnaing.movieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.yeminnaing.movieapplication.data.vos.ActorVo

data class GetCreditByMovieResponse(
    @SerializedName("cast")
    val cast:List<ActorVo>,
    @SerializedName("crew")
    val crew:List<ActorVo>
)
