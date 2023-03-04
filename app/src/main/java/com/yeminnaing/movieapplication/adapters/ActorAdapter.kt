package com.yeminnaing.movieapplication.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeminnaing.movieapplication.R
import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.viewholders.ActorViewHolder

class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>() {
    private var mActorList: List<ActorVo> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
           if (mActorList.isNotEmpty()){
               holder.bindData(mActorList[position])
           }
    }

    override fun getItemCount(): Int {
      return mActorList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(actors: List<ActorVo>) {
        mActorList = actors
        notifyDataSetChanged()
    }
}