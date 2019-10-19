package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.NowPlayingViewHolder

class NowPlayingAdapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<NowPlayingViewHolder, NowPlayingMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return NowPlayingViewHolder(itemView, mMovieItemDelegate)
    }
}