package com.yeminnaing.movieapplication.data.vos

import com.google.gson.annotations.SerializedName

data class ActorVo(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for")
    val knownFor: List<MovieVO>?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("cast_id")
    val castId: String?,
    @SerializedName("character")
    val character: String?,
    @SerializedName("creditId")
    val creditId: String?,
    @SerializedName("order")
    val order: Int?,
)
