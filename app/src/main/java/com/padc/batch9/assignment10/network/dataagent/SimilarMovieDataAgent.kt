package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.SimilarMovieVo

interface SimilarMovieDataAgent {

    fun getSimilarMovies(id:Int,
                         onSuccess:(List<SimilarMovieVo>) -> Unit,
                         onFailure: (String) -> Unit
    )
}