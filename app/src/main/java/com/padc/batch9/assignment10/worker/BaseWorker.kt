package com.padc.batch9.assignment10.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.padc.batch9.assignment10.network.dataagent.*
import com.padc.batch9.assignment10.persistence.MovieDatabase

abstract class  BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    protected val nowPlayingDataAgentNowPlaying:NowPlayingMovieDataAgent = NowPlayingNowPlayingMovieAgentImpl
    protected val topRatedDataAgentNowPlaying:TopRatedMovieDataAgent = TopRatedNowPlayingMovieAgentImpl
    protected val popularDataAgentNowPlaying:PopularMovieDataAgent = PopularNowPlayingMovieAgentImpl
    protected val upComingDataAgentNowPlaying:UpComingMovieDataAgent = UpComingNowPlayingMovieAgentImpl

    protected val database: MovieDatabase = MovieDatabase.getInstance(context)
}