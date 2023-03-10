package com.yeminnaing.movieapplication.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeminnaing.movieapplication.adapters.ActorAdapter
import com.yeminnaing.movieapplication.data.vos.ActorVo
import kotlinx.android.synthetic.main.view_pod_actor_list.view.*

class ActorsListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var mActorAdapter: ActorAdapter
    override fun onFinishInflate() {
        setActorRecyclerView()
        super.onFinishInflate()

    }

    fun setUpActorViewPod(backGroundColorReference: Int, titleText: String, moreTitleText: String) {
        setBackgroundColor(ContextCompat.getColor(context,backGroundColorReference))
        tvBestActor.text = titleText
        tvMoreActors.text = moreTitleText
        tvMoreActors.paintFlags=Paint.UNDERLINE_TEXT_FLAG
    }

    private fun setActorRecyclerView() {
        mActorAdapter = ActorAdapter();
        rvBestActor.adapter = mActorAdapter
        rvBestActor.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun setData(actors: List<ActorVo>) {
      mActorAdapter.setNewData(actors)
    }
}