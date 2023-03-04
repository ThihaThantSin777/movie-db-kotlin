package com.yeminnaing.movieapplication.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.delegates.BannerViewHolderDelegate
import com.yeminnaing.movieapplication.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_item_banner.view.*

class BannerViewHolder(itemView: View, private val mDelegate: BannerViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {
    private var mMovie: MovieVO? =null
    init {
        itemView.setOnClickListener {
            mMovie?.let { movie->
                mDelegate.onTapMovieFromBanner(movie.id ?:0)
            }

        }
    }

    fun bindData(movie: MovieVO) {
        mMovie=movie
        Glide.with(itemView.context)
            .load("${IMAGE_BASE_URL}${movie.backDropPath}")
            .into(itemView.ivBannerImage)

        itemView.tvBannerMovieName.text = movie.title
    }
}