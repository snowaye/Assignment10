package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.SimilarMovieVo

interface SimilarMovieModel {
    fun getSimmilarMovie(id: Int,
        onFailure:(String)-> Unit): LiveData<List<SimilarMovieVo>>

    fun getSimilarMovieById(id:Int): LiveData<SimilarMovieVo>
}