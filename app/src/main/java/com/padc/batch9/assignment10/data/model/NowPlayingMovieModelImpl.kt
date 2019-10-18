package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo

object NowPlayingMovieModelImpl: BaseModel(), NowPlayingMovieModel {

    override fun getNowPlayingMoie(onFailure: (String) -> Unit): LiveData<List<NowPlayingMovieVo>> {
        return Transformations.distinctUntilChanged(
            database.nowPlayingDao().getAllNowPlayingMovies())

    }

    override fun getNowPlayingMovieById(eventId: Int): LiveData<NowPlayingMovieVo> {
        return Transformations.distinctUntilChanged (
            database.nowPlayingDao().getNowPlayingMovieById(eventId)
        )
    }
}