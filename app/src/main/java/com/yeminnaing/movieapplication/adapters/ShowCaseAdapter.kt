package com.yeminnaing.movieapplication.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeminnaing.movieapplication.R
import com.yeminnaing.movieapplication.data.vos.MovieVO
import com.yeminnaing.movieapplication.delegates.BannerViewHolderDelegate
import com.yeminnaing.movieapplication.delegates.ShowCaseViewHolderDelegate
import com.yeminnaing.movieapplication.viewholders.ShowCaseViewHolder

class ShowCaseAdapter(private val mDelegate: ShowCaseViewHolderDelegate) : RecyclerView.Adapter<ShowCaseViewHolder>() {
    private var mMovieList: List<MovieVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_showcase, parent, false)
        return ShowCaseViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: ShowCaseViewHolder, position: Int) {
        if (mMovieList.isNotEmpty()){
            holder.bindData(mMovieList[position])
        }
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(movieList:List<MovieVO>) {
        mMovieList=movieList
        notifyDataSetChanged()
    }
}