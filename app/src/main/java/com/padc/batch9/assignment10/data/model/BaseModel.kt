package com.padc.batch9.assignment10.data.model

import android.content.Context
import com.padc.batch9.assignment10.network.dataagent.*
import com.padc.batch9.assignment10.persistence.MovieDatabase


abstract class BaseModel {
    protected val nowPlayingDataAgentNowPlaying:NowPlayingMovieDataAgent = NowPlayingNowPlayingMovieAgentImpl
    protected val topRatedDataAgentNowPlaying:TopRatedMovieDataAgent = TopRatedNowPlayingMovieAgentImpl
    protected val popularDataAgentNowPlaying:PopularMovieDataAgent = PopularNowPlayingMovieAgentImpl
    protected val upComingDataAgentNowPlaying:UpComingMovieDataAgent = UpComingNowPlayingMovieAgentImpl
    protected val searchMovieDataAgent:SearchMovieDataAgent = SearchMovieDataAgentImpl

    protected lateinit var database: MovieDatabase

    fun initDatabase(context: Context){
        database = MovieDatabase.getInstance(context)
    }
}