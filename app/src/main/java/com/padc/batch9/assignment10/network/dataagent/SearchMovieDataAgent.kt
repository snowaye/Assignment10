package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.SearchMovieVo

interface SearchMovieDataAgent {

    fun searchMovie(query:String, onSuccess: (List<SearchMovieVo>) -> Unit, onFailure:(String) -> Unit)
}