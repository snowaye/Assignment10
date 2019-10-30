package com.padc.batch9.assignment10.data.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment10.data.vo.SearchMovieVo

object SearchMovieModelImpl:BaseModel(), SearchMovieModel {


    override fun searchMovieById(id: Int): LiveData<SearchMovieVo> {
        return Transformations.distinctUntilChanged (
            database.searchMovieDao().getSearchMovieById(id)
        )
    }

    override fun searchMovie(
        query: String,
        onFailure: (String) -> Unit
    ): LiveData<List<SearchMovieVo>>{
        val searchFromDB = database.searchMovieDao().getAllSearchMovies()

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