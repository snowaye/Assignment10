package com.padc.batch9.assignment10.viewholder

import android.view.View
import coil.api.load
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.util.BASE_URL
import com.padc.batch9.assignment10.util.CASE_POPULAR
import com.padc.batch9.assignment10.util.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.listitem_movie.view.*

class PopularViewHolder(itemView: View,
                        private val delegate: MovieItemDelegate):BaseViewHolder<PopularMovieVo>(itemView) {
    override fun bindData(data: PopularMovieVo) {
        itemView.imgv_movie.load(
            IMAGE_BASE_URL +data.posterPath
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
                delegate.onTapMovieItemDelegate(id, CASE_POPULAR)
            }
        }
    }

}