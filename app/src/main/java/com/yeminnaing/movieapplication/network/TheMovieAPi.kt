package com.yeminnaing.movieapplication.network

import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.network.responses.GetActorResponse
import com.yeminnaing.movieapplication.network.responses.GetCreditByMovieResponse
import com.yeminnaing.movieapplication.network.responses.GetGenreResponse
import com.yeminnaing.movieapplication.network.responses.MovieListResponse
import com.yeminnaing.movieapplication.utils.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieAPi {
    @GET(API_GET_NOW_PLAYING)
    fun getNowPlayingMovie(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>

    @GET(API_GET_POPULAR_MOVIE)
    fun getPopularMovie(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>

    @GET(API_GET_TOP_RATED_MOVIE)
    fun getTopRatedMovie(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>


    @GET(API_GET_GENRE)
    fun getGenre(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
    ): Call<GetGenreResponse>

    @GET(API_GET_MOVIE_BY_GENRE)
    fun getMovieByGenre(
        @Query(PARAM_GENRE_ID) genreId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
    ): Call<MovieListResponse>

    @GET(API_GET_ACTORS)
    fun getActors(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<GetActorResponse>


    @GET("$API_GET_MOVIE_DETAILS/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieVO>

    @GET("$API_GET_CREDITS_BY_MOVIE/{movie_id}/credits")
    fun getCreditByMovie(
        @Path("movie_id") movieId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<GetCreditByMovieResponse>
}