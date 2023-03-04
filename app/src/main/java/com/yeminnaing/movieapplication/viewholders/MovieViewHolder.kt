package com.yeminnaing.movieapplication.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.delegates.MovieViewHolderDelegate
import com.yeminnaing.movieapplication.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class MovieViewHolder(itemView: View, private val mDelegate: MovieViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {
    private var mMovie: MovieVO? = null

    init {
        itemView.setOnClickListener {
            mMovie?.let {
                mDelegate.onTapMovie(it.id?:0)
            }
        }
    }

    fun bindData(movie: MovieVO) {
        mMovie = movie

        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(itemView.ivMoveImage)

        itemView.tvMovieNameHolder.text = movie.title?:""
        itemView.tvMovieRating.text = movie.voteAverage?.toString()
        itemView.rbMovieRating.rating = movie.getRatingBaseOnFiveStar()

    }

}