package com.yeminnaing.movieapplication.network.dataagents

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.network.responses.MovieListResponse
import com.yeminnaing.movieapplication.utils.API_GET_NOW_PLAYING
import com.yeminnaing.movieapplication.utils.BASE_URL
import com.yeminnaing.movieapplication.utils.MOVIE_API_KEY
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

//object MovieDataAgentImpl : MovieDataAgent {
//    override fun getNowPlayingMovies(
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//  GetTopRatedMovieTask().execute()
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
//    class GetTopRatedMovieTask() : AsyncTask<Void, Void, MovieListResponse>() {
//        override fun doInBackground(vararg p0: Void?): MovieListResponse? {
//            val url: URL
//            var reader: BufferedReader? = null
//            val stringBuilder: java.lang.StringBuilder
//
//            try {
//                url =
//                    URL("""$BASE_URL$API_GET_NOW_PLAYING?api_key=$MOVIE_API_KEY&language=en-US&page=1 """)
//                val connection = url.openConnection() as HttpURLConnection
//
//                connection.requestMethod = "GET"
//
//                connection.readTimeout = 15 * 1000
//
//                connection.doInput = true
//
//                connection.doOutput = false
//
//                connection.connect()
//
//                reader = BufferedReader(
//                    InputStreamReader(connection.inputStream)
//                )
//
//                stringBuilder = StringBuilder()
//
//                for (line in reader.readLine()) {
//
//                    stringBuilder.append(line + "\n")
//
//                }
//                val responseString = stringBuilder.toString()
//                Log.d("NowPlayingMovies", responseString)
//
//                val movieListResponse = Gson().fromJson(
//                    responseString,
//                    MovieListResponse::class.java
//                )
//                return movieListResponse
//            } catch (e: java.lang.Exception) {
//                e.printStackTrace()
//                Log.e("NewsErrors", e.message ?: "")
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close()
//                    } catch (ioe: IOException) {
//                        ioe.printStackTrace()
//                    }
//                }
//
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: MovieListResponse?) {
//            super.onPostExecute(result)
//        }
//    }
//
//}