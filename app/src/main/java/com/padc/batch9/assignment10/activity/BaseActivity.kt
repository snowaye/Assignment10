package com.padc.batch9.assignment10.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.batch9.assignment10.data.model.*


abstract class BaseActivity: AppCompatActivity() {
    protected lateinit var nowPlayingModel: NowPlayingMovieModel
    protected lateinit var popularModel:PopularMovieModel
    protected lateinit var topRatedMovieModel: TopRatedMovieModel
    protected lateinit var upComingMovieModel: UpComingMovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nowPlayingModel = NowPlayingMovieModelImpl
        popularModel = PopularMovieModelImpl
        topRatedMovieModel = TopRatedMovieModelImpl
        upComingMovieModel = UpComingMovieModelImpl
    }
}