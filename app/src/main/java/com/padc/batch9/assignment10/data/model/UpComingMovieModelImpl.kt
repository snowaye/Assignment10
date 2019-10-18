package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

object UpComingMovieModelImpl: BaseModel(), UpComingMovieModel {
    override fun getUpComingMovies(onFailure: (String) -> Unit): LiveData<List<UpComingMovieVo>> {
        return Transformations.distinctUntilChanged(
            database.upComingDao().getAllUpComingMovies())
    }

    override fun getUpComingMoviesById(id: Int): LiveData<UpComingMovieVo> {
        return Transformations.distinctUntilChanged (
            database.upComingDao().getUpComingMovieById(id)
        )
    }

 }