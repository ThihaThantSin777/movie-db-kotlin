package com.yeminnaing.movieapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.yeminnaing.movieapplication.data.vos.ActorVo

data class GetActorResponse(
    @SerializedName("results")
    val results:List<ActorVo>
)
