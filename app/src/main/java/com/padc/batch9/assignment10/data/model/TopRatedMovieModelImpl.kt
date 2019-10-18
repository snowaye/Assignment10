package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo

object TopRatedMovieModelImpl: BaseModel(), TopRatedMovieModel {
    override fun getTopRatedgMovies(onFailure: (String) -> Unit): LiveData<List<TopRatedMovieVo>> {
        return Transformations.distinctUntilChanged(
            database.topRatedDao().getAllTopRatedMovies())
    }

    override fun getTopRatedMoviesById(id: Int): LiveData<TopRatedMovieVo> {
        return Transformations.distinctUntilChanged (
            database.topRatedDao().getTopRatedMovieById(id)
        )
    }


}