package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.NowPlayingViewHolder
import com.padc.batch9.assignment10.viewholder.PopularViewHolder

class PopularAdapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<PopularViewHolder, PopularMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return PopularViewHolder(itemView, mMovieItemDelegate)
    }
}