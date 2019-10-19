package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.UpComingViewHolder

class UpComingAdapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<UpComingViewHolder, UpComingMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return UpComingViewHolder(itemView, mMovieItemDelegate)
    }
}