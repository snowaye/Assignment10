package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.SimilarMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.SimilarMovieViewHolder

class SimilarMoviedapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<SimilarMovieViewHolder, SimilarMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return SimilarMovieViewHolder(itemView, mMovieItemDelegate)
    }
}