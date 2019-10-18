package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

interface UpComingMovieModel {

    fun getUpComingMovies(
        onFailure:(String)-> Unit): LiveData<List<UpComingMovieVo>>

    fun getUpComingMoviesById(id:Int): LiveData<UpComingMovieVo>
}