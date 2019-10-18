package com.padc.batch9.assignment10.network.dataagent


import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo


interface TopRatedMovieDataAgent {

    fun getTopRatedMovies(onSuccess: (List<TopRatedMovieVo>) -> Unit, onFailure:(String) -> Unit)
}