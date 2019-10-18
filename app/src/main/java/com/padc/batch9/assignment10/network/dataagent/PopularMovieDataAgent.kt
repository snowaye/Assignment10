package com.padc.batch9.assignment10.network.dataagent


import com.padc.batch9.assignment10.data.vo.PopularMovieVo


interface PopularMovieDataAgent {

    fun getPopularMovies(onSuccess: (List<PopularMovieVo>) -> Unit, onFailure:(String) -> Unit)
}