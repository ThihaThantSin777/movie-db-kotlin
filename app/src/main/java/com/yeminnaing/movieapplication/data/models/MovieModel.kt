package com.yeminnaing.movieapplication.data.models

import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO

interface MovieModel {
    fun getNowPlayingMovie(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getPopularMovie(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getTopRatedMovie(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getGenre(
        onSuccess: (List<GenreVo>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getMovieByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getActors(
        onSuccess: (List<ActorVo>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getMovieDetails(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getCreditByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVo>,List<ActorVo>>) -> Unit,
        onFailure: (String) -> Unit,
    )
}