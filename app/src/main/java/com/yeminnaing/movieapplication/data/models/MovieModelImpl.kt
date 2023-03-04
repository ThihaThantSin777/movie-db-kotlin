package com.yeminnaing.movieapplication.data.models

import android.content.Context
import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.network.dataagents.MovieDataAgent
import com.yeminnaing.movieapplication.network.dataagents.RetrofitDataAgentsImpl
import com.yeminnaing.movieapplication.persistent.MovieDataBase
import com.yeminnaing.movieapplication.utils.NOW_PLAYING
import com.yeminnaing.movieapplication.utils.POPULAR_MOVIE
import com.yeminnaing.movieapplication.utils.TOP_RATED

object MovieModelImpl : MovieModel {
    ///Network
    private val mMovieDataAgent: MovieDataAgent = RetrofitDataAgentsImpl

    ///Database
    private var mMovieDataBase: MovieDataBase? = null;
    override fun getNowPlayingMovie(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        ///Database
        onSuccess(mMovieDataBase?.movieDAO()?.getMovieByType(type = NOW_PLAYING) ?: listOf())

        ///Network
        mMovieDataAgent.getNowPlayingMovies(onSuccess = {
            it.forEach { movieVO -> movieVO.type = NOW_PLAYING }
            mMovieDataBase?.movieDAO()?.insertMovies(it);
            onSuccess(it)
        }, onFailure = onFailure)
    }

    fun initDatabase(context: Context) {
        mMovieDataBase = MovieDataBase.getDBInstance(context);
    }

    override fun getPopularMovie(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        ///Database
        onSuccess(mMovieDataBase?.movieDAO()?.getMovieByType(type = POPULAR_MOVIE) ?: listOf())

        ///Network
        mMovieDataAgent.getPopularMovie(onSuccess = {
            it.forEach { movieVO -> movieVO.type = POPULAR_MOVIE }
            mMovieDataBase?.movieDAO()?.insertMovies(it);
            onSuccess(it)
        }, onFailure = onFailure)
    }

    override fun getTopRatedMovie(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        ///Database
        onSuccess(mMovieDataBase?.movieDAO()?.getMovieByType(type = TOP_RATED) ?: listOf())

        ///Network
        mMovieDataAgent.getTopRatedMovie(onSuccess = {
            it.forEach { movieVO -> movieVO.type = TOP_RATED }
            mMovieDataBase?.movieDAO()?.insertMovies(it);
            onSuccess(it)
        }, onFailure = onFailure)
    }

    override fun getGenre(onSuccess: (List<GenreVo>) -> Unit, onFailure: (String) -> Unit) {
        mMovieDataAgent.getGenre(onSuccess = onSuccess, onFailure = onFailure)
    }

    override fun getMovieByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mMovieDataAgent.getMovieByGenre(
            genreId = genreId,
            onSuccess = onSuccess,
            onFailure = onFailure
        )

    }

    override fun getActors(onSuccess: (List<ActorVo>) -> Unit, onFailure: (String) -> Unit) {
        mMovieDataAgent.getActors(
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

    override fun getMovieDetails(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit,
    ) {

        ///Database
        val movieDataBase = mMovieDataBase?.movieDAO()?.getMovieByID(movieID = movieId.toInt())
        movieDataBase?.let {
            onSuccess(it);
        }

        ///Network
        mMovieDataAgent.getMovieDetail(
            movieId = movieId,
            onSuccess = {
                val movieDataBase =
                    mMovieDataBase?.movieDAO()?.getMovieByID(movieID = movieId.toInt())
                it.type = movieDataBase?.type;
                mMovieDataBase?.movieDAO()?.insertSingleMovies(it);
                onSuccess(it);
            },
            onFailure = onFailure
        )
    }

    override fun getCreditByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVo>, List<ActorVo>>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mMovieDataAgent.getCreditByMovie(
            movieId = movieId,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }
}