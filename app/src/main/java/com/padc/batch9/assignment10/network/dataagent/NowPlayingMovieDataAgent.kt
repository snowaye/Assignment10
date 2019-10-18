package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo


interface NowPlayingMovieDataAgent {

    fun getNowPlayingMovies(onSuccess: (List<NowPlayingMovieVo>) -> Unit, onFailure:(String) -> Unit)
}