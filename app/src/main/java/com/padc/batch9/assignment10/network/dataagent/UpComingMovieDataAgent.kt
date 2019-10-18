package com.padc.batch9.assignment10.network.dataagent


import com.padc.batch9.assignment10.data.vo.UpComingMovieVo


interface UpComingMovieDataAgent {

    fun getUpcomingMovies(onSuccess: (List<UpComingMovieVo>) -> Unit, onFailure:(String) -> Unit)
}