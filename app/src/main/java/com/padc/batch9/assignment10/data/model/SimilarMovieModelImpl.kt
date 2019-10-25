package com.padc.batch9.assignment10.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ListenableWorker
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.SimilarMovieVo

object SimilarMovieModelImpl: BaseModel(), SimilarMovieModel {
    override fun getSimmilarMovie(
        id: Int,
        onFailure: (String) -> Unit
    ): LiveData<List<SimilarMovieVo>> {
        val similarMovieFromDB = database.similarMovieDao().getAllSimilarMovies()
        similarMovieDataAgent.getSimilarMovies(id,
            {
               database.similarMovieDao().insertSimilarMovies(it)
            },
            {
                onFailure
            })
        return  similarMovieFromDB
    }

    override fun getSimilarMovieById(id: Int): LiveData<SimilarMovieVo> {
       return database.similarMovieDao().getSimilarMovieById(id)
    }

}