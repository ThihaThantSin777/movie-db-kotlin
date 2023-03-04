package com.yeminnaing.movieapplication.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.delegates.ShowCaseViewHolderDelegate
import com.yeminnaing.movieapplication.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_showcase.view.*

class ShowCaseViewHolder(itemView: View, private val mDelegate: ShowCaseViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {

  private var mMovie:MovieVO?=null
    init {
        itemView.setOnClickListener {
            mMovie?.let {
               mDelegate.onTapMovieFromShowCase(it.id)
            }

        }
    }

    fun bindData(movie: MovieVO) {
          mMovie=movie
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${movie.backDropPath}")
            .into(itemView.ivShowCase)

        itemView.tvShowCaseMovieName.text = movie.title
        itemView.tvShowCaseMovieDate.text = movie.releaseDate
    }
}