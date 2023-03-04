package com.yeminnaing.movieapplication.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeminnaing.movieapplication.data.vos.ActorVo
import com.yeminnaing.movieapplication.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_actor.view.*
import kotlinx.android.synthetic.main.view_item_banner.view.*

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(actors: ActorVo) {
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${actors.profilePath}")
            .into(itemView.ivActor)

        itemView.tvActorName.text=actors.name
    }
}