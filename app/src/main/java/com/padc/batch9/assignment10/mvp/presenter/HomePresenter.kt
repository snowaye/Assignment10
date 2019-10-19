package com.padc.batch9.assignment10.mvp.presenter

import androidx.lifecycle.Observer
import com.padc.batch9.assignment10.activity.BaseActivity
import com.padc.batch9.assignment10.data.model.NowPlayingMovieModelImpl
import com.padc.batch9.assignment10.data.model.PopularMovieModelImpl
import com.padc.batch9.assignment10.data.model.TopRatedMovieModelImpl
import com.padc.batch9.assignment10.data.model.UpComingMovieModelImpl
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.mvp.view.HomeMovieListView

class HomePresenter: BasePresenter<HomeMovieListView>(), MovieItemDelegate {
    override fun onTapMovieItemDelegate(id: Int, from: String) {
       mView.navigateToDetail(id, from)
    }


    fun onUIReady(activity: BaseActivity) {
        var nowPlayingMovieModel = NowPlayingMovieModelImpl
        nowPlayingMovieModel.getNowPlayingMoie {
            mView.displayError(it)
        }.observe(activity, Observer { mView.displayNowPlyingList(it) })

        var popularMovieModel = PopularMovieModelImpl
        popularMovieModel.getPopularMoies {
            mView.displayError(it)
        }.observe(activity, Observer { mView.displayPopularList(it) })

        var topRatedMovieModel = TopRatedMovieModelImpl
        topRatedMovieModel.getTopRatedgMovies {
            mView.displayError(it)
        }.observe(activity, Observer { mView.displayTopRateList(it) })

        var upComingMovieModel = UpComingMovieModelImpl
        upComingMovieModel.getUpComingMovies {
            mView.displayError(it)
        }.observe(activity, Observer { mView.displayUpComingList(it) })

    }
}