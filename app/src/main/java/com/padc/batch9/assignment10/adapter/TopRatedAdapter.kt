package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.TopRatedViewHolder

class TopRatedAdapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<TopRatedViewHolder, TopRatedMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return TopRatedViewHolder(itemView, mMovieItemDelegate)
    }
}