package com.padc.batch9.assignment10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.SearchMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.viewholder.SearchMovieViewHolder

class SearchMovieAdapter(private val mMovieItemDelegate: MovieItemDelegate):BaseAdapter<SearchMovieViewHolder, SearchMovieVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie,parent, false)
        return SearchMovieViewHolder(itemView, mMovieItemDelegate)
    }
}