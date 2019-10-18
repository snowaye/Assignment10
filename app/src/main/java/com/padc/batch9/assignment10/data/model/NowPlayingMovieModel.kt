package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo

interface NowPlayingMovieModel {
    fun getNowPlayingMoie(
        onFailure:(String)-> Unit): LiveData<List<NowPlayingMovieVo>>

    fun getNowPlayingMovieById(id:Int): LiveData<NowPlayingMovieVo>
}