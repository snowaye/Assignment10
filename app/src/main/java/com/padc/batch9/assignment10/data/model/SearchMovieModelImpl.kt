package com.padc.batch9.assignment10.data.model


import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.SearchMovieVo

object SearchMovieModelImpl:BaseModel(), SearchMovieModel {

    override fun searchMovie(
        query: String,
        onFailure: (String) -> Unit
    ): LiveData<List<SearchMovieVo>>{
        val searchFromDB = database.searchMovieDao().getAllSearchMovies()
        var list: List<SearchMovieVo> = ArrayList<SearchMovieVo>()
        searchMovieDataAgent.searchMovie(query,
            {
                database.searchMovieDao().insertSearchMovies(it)
            },
            {
                onFailure
            }
        )
        return searchFromDB
    }

}