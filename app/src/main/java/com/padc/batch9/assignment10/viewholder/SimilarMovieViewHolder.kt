package com.padc.batch9.assignment10.viewholder

import android.view.View
import coil.api.load
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.SimilarMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.util.BASE_URL
import com.padc.batch9.assignment10.util.CASE_NOW_PLAYING
import com.padc.batch9.assignment10.util.CASE_SIMILAR
import com.padc.batch9.assignment10.util.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.listitem_movie.view.*

class SimilarMovieViewHolder(itemView: View,
                             private val delegate: MovieItemDelegate):BaseViewHolder<SimilarMovieVo>(itemView) {
    override fun bindData(data: SimilarMovieVo) {
        itemView.imgv_movie.load(
            IMAGE_BASE_URL+data.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }

    init {
        itemView.setOnClickListener {
            val id = data?.id
            data?.id?.let {id->
                delegate.onTapMovieItemDelegate(id, CASE_SIMILAR)
            }
        }
    }

   }