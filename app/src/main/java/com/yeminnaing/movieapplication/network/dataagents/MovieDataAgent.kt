package com.yeminnaing.movieapplication.network.dataagents

import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO

interface MovieDataAgent {
    fun getNowPlayingMovies(
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

    fun getMovieDetail(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getCreditByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVo>, List<ActorVo>>) -> Unit,
        onFailure: (String) -> Unit,
    )

}