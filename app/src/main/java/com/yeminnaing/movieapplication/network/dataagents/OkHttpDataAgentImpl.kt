package com.yeminnaing.movieapplication.network.dataagents

import android.os.AsyncTask
import com.google.gson.Gson
import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.network.responses.MovieListResponse
import com.yeminnaing.movieapplication.utils.API_GET_NOW_PLAYING
import com.yeminnaing.movieapplication.utils.BASE_URL
import com.yeminnaing.movieapplication.utils.MOVIE_API_KEY
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

//object OkHttpDataAgentImpl : MovieDataAgent {
//    private val mClient: OkHttpClient = OkHttpClient.Builder()
//        .connectTimeout(15, TimeUnit.SECONDS)
//        .readTimeout(15, TimeUnit.SECONDS)
//        .writeTimeout(15, TimeUnit.SECONDS)
//        .build()
//
//    override fun getNowPlayingMovies(
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//        GetNowPlayingMovieOkHttpTask(mClient).execute()
//    }
//
//    override fun getPopularMovie(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
//
//    }
//
//    override fun getTopRatedMovie(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
//
//    }
//
//    override fun getGenre(onSuccess: (List<GenreVo>) -> Unit, onFailure: (String) -> Unit) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getMovieByGenre(
//        genreId: String,
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit,
//    ) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getActors(onSuccess: (List<ActorVo>) -> Unit, onFailure: (String) -> Unit) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getMovieDetail(
//        movieId: String,
//        onSuccess: (MovieVO) -> Unit,
//        onFailure: (String) -> Unit,
//    ) {
//        TODO("Not yet implemented")
//    }
//
//    class GetNowPlayingMovieOkHttpTask(
//        private val mOkHttpClient: OkHttpClient,
//    ) : AsyncTask<Void, Void, MovieListResponse>() {
//        override fun doInBackground(vararg p0: Void?): MovieListResponse? {
//
//            val request = okhttp3.Request.Builder()
//                .url("""$BASE_URL$API_GET_NOW_PLAYING?api_key=$MOVIE_API_KEY&language=en-US&page=1 """)
//                .build()
//
//            try {
//                val response = mOkHttpClient.newCall(request).execute()
//                if (response.isSuccessful) {
//                    response.body?.let {
//                        val responseString = it.string()
//                        val response = Gson()
//                            .fromJson(
//                                responseString,
//                                MovieListResponse::class.java
//                            )
//                        return response
//                    }
//                }
//            } catch (e: java.lang.Exception) {
//                e.printStackTrace()
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: MovieListResponse?) {
//            super.onPostExecute(result)
//        }
//
//    }
//
//}