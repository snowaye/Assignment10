package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment10.data.vo.PopularMovieVo


object PopularMovieModelImpl: BaseModel(), PopularMovieModel {
    override fun getPopularMoies(onFailure: (String) -> Unit): LiveData<List<PopularMovieVo>> {
        return Transformations.distinctUntilChanged(
            database.popularDao().getAllPopularMovies())
    }

    override fun getPopularMovieById(id: Int): LiveData<PopularMovieVo> {
        return Transformations.distinctUntilChanged (
            database.popularDao().getPoularMovieById(id)
        )
    }


}