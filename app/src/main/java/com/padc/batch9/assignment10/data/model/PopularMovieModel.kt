package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo

interface PopularMovieModel {
    fun getPopularMoies(
        onFailure:(String)-> Unit): LiveData<List<PopularMovieVo>>

    fun getPopularMovieById(id:Int): LiveData<PopularMovieVo>
}