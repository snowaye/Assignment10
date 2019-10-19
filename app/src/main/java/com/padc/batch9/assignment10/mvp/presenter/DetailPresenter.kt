package com.padc.batch9.assignment10.mvp.presenter

import com.padc.batch9.assignment10.data.model.NowPlayingMovieModelImpl
import com.padc.batch9.assignment10.data.model.PopularMovieModelImpl
import com.padc.batch9.assignment10.data.model.TopRatedMovieModelImpl
import com.padc.batch9.assignment10.data.model.UpComingMovieModelImpl
import com.padc.batch9.assignment10.mvp.view.MovieDetailView
import com.padc.batch9.assignment10.util.CASE_NOW_PLAYING
import com.padc.batch9.assignment10.util.CASE_POPULAR
import com.padc.batch9.assignment10.util.CASE_TOP_RATED
import com.padc.batch9.assignment10.util.CASE_UPCOMING

class DetailPresenter: BasePresenter<MovieDetailView>() {

    fun onUIReady(id:Int, from:String) {
        if (id !=0) {
            when (from) {
                CASE_NOW_PLAYING -> {
                    val model = NowPlayingMovieModelImpl

                    val movieVo = model.getNowPlayingMovieById(id)
                        .observeForever {
                            mView.displayNowPlayingData(it)
                        }
                }
                CASE_POPULAR -> {
                    val model = PopularMovieModelImpl

                    val movieVo = model.getPopularMovieById(id)
                        .observeForever {
                            mView.displalyPopularData(it)
                        }
                }
                CASE_TOP_RATED -> {
                    val model = TopRatedMovieModelImpl

                    val movieVo = model.getTopRatedMoviesById(id)
                        .observeForever {
                            mView.displayTopRatedData(it)
                        }
                }
                CASE_UPCOMING -> {
                    val model = UpComingMovieModelImpl

                    val movieVo = model.getUpComingMoviesById(id)
                        .observeForever {
                            mView.displayUpComingData(it)
                        }
                }
            }

        }
    }
}