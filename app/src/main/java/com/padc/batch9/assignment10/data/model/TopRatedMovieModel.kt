package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo

interface TopRatedMovieModel {

    fun getTopRatedgMovies(
        onFailure:(String)-> Unit): LiveData<List<TopRatedMovieVo>>

    fun getTopRatedMoviesById(id:Int): LiveData<TopRatedMovieVo>
}