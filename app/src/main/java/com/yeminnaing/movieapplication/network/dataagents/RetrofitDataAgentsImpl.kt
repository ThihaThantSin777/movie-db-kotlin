package com.yeminnaing.movieapplication.network.dataagents

import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.network.TheMovieAPi
import com.yeminnaing.movieapplication.network.responses.GetActorResponse
import com.yeminnaing.movieapplication.network.responses.GetCreditByMovieResponse
import com.yeminnaing.movieapplication.network.responses.GetGenreResponse
import com.yeminnaing.movieapplication.network.responses.MovieListResponse
import com.yeminnaing.movieapplication.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentsImpl : MovieDataAgent {

    private var mTheMovieAPi: TheMovieAPi? = null

    init {
        val mOkHttpClient = OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

        mTheMovieAPi = retrofit.create(TheMovieAPi::class.java)

    }

    override fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mTheMovieAPi?.getNowPlayingMovie()?.enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>,
            ) {
                if (response.isSuccessful) {
                        val movieList = response.body()?.result ?: listOf()
                    onSuccess(movieList)
                } else {
                    onFailure(response.message())
                }

            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                onFailure(t.message ?: "")
            }

        })
    }

    //    GetPopularMovie
    override fun getPopularMovie(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mTheMovieAPi?.getPopularMovie()?.enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>,
            ) {
                if (response.isSuccessful) {
                    val movieList = response.body()?.result ?: listOf()
                    onSuccess(movieList)
                } else {
                    onFailure(response.message())
                }
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                onFailure(t.message ?: "")
            }

        })
    }

    //GetTopRatedMovie
    override fun getTopRatedMovie(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {

        mTheMovieAPi?.getTopRatedMovie()?.enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>,
            ) {
                if (response.isSuccessful) {
                    val movieList = response.body()?.result ?: listOf()
                    onSuccess(movieList)
                } else {
                    onFailure(response.message())
                }
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                onFailure(t.message ?: "")
            }

        })
    }

    override fun getGenre(onSuccess: (List<GenreVo>) -> Unit, onFailure: (String) -> Unit) {
        mTheMovieAPi?.getGenre()?.enqueue(object : Callback<GetGenreResponse> {
            override fun onResponse(
                call: Call<GetGenreResponse>,
                response: Response<GetGenreResponse>,
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()?.genres ?: listOf())
                } else {
                    onFailure(response.message())
                }
            }

            override fun onFailure(call: Call<GetGenreResponse>, t: Throwable) {
                onFailure(t.message ?: "")
            }

        })
    }

    override fun getMovieByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mTheMovieAPi?.getMovieByGenre(genreId = genreId)
            ?.enqueue(object : Callback<MovieListResponse> {
                override fun onResponse(
                    call: Call<MovieListResponse>,
                    response: Response<MovieListResponse>,
                ) {
                    if (response.isSuccessful) {
                        val movieList = response.body()?.result ?: listOf()
                        onSuccess(movieList)
                    } else {
                        onFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                    onFailure(t.message ?: "")
                }

            })

    }

    override fun getActors(onSuccess: (List<ActorVo>) -> Unit, onFailure: (String) -> Unit) {
        mTheMovieAPi?.getActors()?.enqueue(object : Callback<GetActorResponse> {
            override fun onResponse(
                call: Call<GetActorResponse>,
                response: Response<GetActorResponse>,
            ) {
                if (response.isSuccessful) {
                    onSuccess(response?.body()?.results ?: listOf())
                } else {
                    onFailure(response.message())
                }
            }

            override fun onFailure(call: Call<GetActorResponse>, t: Throwable) {
                onFailure(t.message ?: "")
            }


        })
    }

    override fun getMovieDetail(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mTheMovieAPi?.getMovieDetails(movieId = movieId)
            ?.enqueue(object :Callback<MovieVO>{
                override fun onResponse(call: Call<MovieVO>, response: Response<MovieVO>) {
                  if (response.isSuccessful){
                      response.body()?.let {
                          onSuccess(it)
                      }
                  }else{
                      onFailure(response.message())
                  }
                }

                override fun onFailure(call: Call<MovieVO>, t: Throwable) {
                    onFailure(t.message?:"")
                }

            })
    }

    override fun getCreditByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVo>, List<ActorVo>>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
            mTheMovieAPi?.getCreditByMovie(movieId=movieId)
                ?.enqueue(object : Callback<GetCreditByMovieResponse>{
                    override fun onResponse(
                        call: Call<GetCreditByMovieResponse>,
                        response: Response<GetCreditByMovieResponse>,
                    ) {
                        if (response.isSuccessful){
                            response.body()?.let {
                                onSuccess(Pair(it.cast?: listOf(),it.crew?: listOf()))
                            }
                        }else{
                            onFailure(response.message())
                        }
                    }

                    override fun onFailure(call: Call<GetCreditByMovieResponse>, t: Throwable) {
                           onFailure(t.message?:"")
                    }

                })
    }
}