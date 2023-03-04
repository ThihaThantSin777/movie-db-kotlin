package com.yeminnaing.movieapplication.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yeminnaing.movieapplication.R
import com.yeminnaing.movieapplication.data.models.MovieModel
import com.yeminnaing.movieapplication.data.models.MovieModelImpl
import com.yeminnaing.movieapplication.data.vos.GenreVo
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.utils.IMAGE_BASE_URL
import com.yeminnaing.movieapplication.viewpods.ActorsListViewPod
import kotlinx.android.synthetic.main.activity_movie_details.*


class MovieDetailsActivity : AppCompatActivity() {
    private val mMovieModel: MovieModel = MovieModelImpl

    companion object {
        private const val EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID"
        fun newIntent(context: Context, movieId: Long): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    //viewPods
    lateinit var actorsViewPod: ActorsListViewPod
    lateinit var creatorsViewPod: ActorsListViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setUpViewpod()
        setUpListener()
        val movieId = intent?.getLongExtra(EXTRA_MOVIE_ID, 0)

        movieId?.let {
            requestData(it)
            println(it)
        }


    }

    private fun requestData(movieId: Long) {
        mMovieModel.getMovieDetails(
            movieId = movieId.toString(),
            onSuccess = {
                bindData(it)
            }, onFailure = {

            }
        )

        mMovieModel.getCreditByMovie(
            movieId = movieId.toString(),
            onSuccess = {
                actorsViewPod.setData(it.first)
                creatorsViewPod.setData(it.second)
            }, onFailure = {

            }
        )
    }


    private fun setUpListener() {
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpViewpod() {
        actorsViewPod = vpActors as ActorsListViewPod
        actorsViewPod.setUpActorViewPod(
            backGroundColorReference = R.color.colorPrimary,
            titleText = getString(R.string.lbl_actors),
            moreTitleText = ""
        )

        creatorsViewPod = vpCreators as ActorsListViewPod
        creatorsViewPod.setUpActorViewPod(
            backGroundColorReference = R.color.colorPrimary,
            titleText = getString(R.string.lbl_creators),
            moreTitleText = getString(R.string.lbl_more_creators)
        )
    }


    private fun bindData(movie: MovieVO) {
        Glide.with(this)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(ivMovieDetail)

        tvMovieName.text = movie.title ?: ""
        tvMovieReleaseYear.text = movie.releaseDate?.substring(0, 4)
        tvRating.text = movie.voteAverage?.toString() ?: ""
        movie.voteCount?.let {
            tvNumberOfVotes.text = "$it VOTES"
        }
        rbRatingMovieDetail.rating = movie.getRatingBaseOnFiveStar()

        bindGenre(movie, movie.genres ?: listOf())

        tvOverView.text = movie.overView ?: ""
        tvOriginalTitle.text = movie.title ?: ""
        tvType.text = movie.getGenresAsCommaSeparatedString()

        tvProduction.text = movie.getProductionCountriesAsCommaSeparated()
        tvPremiere.text = movie.releaseDate ?: ""
        tvDescription.text = movie.overView ?: ""
    }

    private fun bindGenre(
        movie: MovieVO,
        genre: List<GenreVo>,
    ) {
        movie.genres?.count()?.let {
            tvFistGenre.text = genre.firstOrNull()?.name ?: ""
            tvSecondGenre.text = genre.getOrNull(1)?.name ?: ""
            tvThirdGenre.text = genre.getOrNull(2)?.name ?: ""

        }
    }
}