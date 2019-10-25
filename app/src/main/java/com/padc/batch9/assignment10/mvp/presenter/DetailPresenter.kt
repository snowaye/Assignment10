package com.padc.batch9.assignment10.mvp.presenter

import androidx.lifecycle.Observer
import com.padc.batch9.assignment10.activity.BaseActivity
import com.padc.batch9.assignment10.data.model.*
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.mvp.view.MovieDetailView
import com.padc.batch9.assignment10.util.*

class DetailPresenter: BasePresenter<MovieDetailView>(), MovieItemDelegate {
    override fun onTapMovieItemDelegate(id: Int, from: String) {
    }

    fun onUIReady(id:Int, from:String, activity: BaseActivity) {
        if (id !=0) {
            when (from) {
                CASE_NOW_PLAYING -> {
                    val model = NowPlayingMovieModelImpl
                    model.getNowPlayingMovieById(id).observe(activity, Observer {
                        mView.displayNowPlayingData(it)
                        val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
                        {
                            mView.displaySimilarMovieError(it)
                        }
                            .observeForever{mView.displaySimilarMovies(it)}

                    })

//                    val movieVo = model.getNowPlayingMovieById(id)
//                        .observeForever {
//                            mView.displayNowPlayingData(it)
//                            val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
//                                {
//                                    mView.displaySimilarMovieError(it)
//                                }
//
//                            mView.displaySimilarMovies(list.)
//                        }
                }
                CASE_POPULAR -> {
                    val model = PopularMovieModelImpl

                    model.getPopularMovieById(id).observe(activity, Observer {
                        mView.displalyPopularData(it)
                        val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
                        {
                            mView.displaySimilarMovieError(it)
                        }
                            .observeForever{mView.displaySimilarMovies(it)}

                    })

//                    val movieVo = model.getPopularMovieById(id)
//                        .observeForever {
//                            mView.displalyPopularData(it)
//                            val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
//                            {
//                                mView.displaySimilarMovieError(it)
//                            }
//                            mView.displaySimilarMovies(list)
//                        }
                }
                CASE_TOP_RATED -> {
                    val model = TopRatedMovieModelImpl
                    model.getTopRatedMoviesById(id).observe(activity, Observer {
                        mView.displayTopRatedData(it)
                        val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
                        {
                            mView.displaySimilarMovieError(it)
                        }
                            .observeForever{mView.displaySimilarMovies(it)}

                    })

//                    val movieVo = model.getTopRatedMoviesById(id)
//                        .observeForever {
//                            mView.displayTopRatedData(it)
//                            val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
//                            {
//                                mView.displaySimilarMovieError(it)
//                            }
//                            mView.displaySimilarMovies(list)
//                        }
                }
                CASE_UPCOMING -> {
                    val model = UpComingMovieModelImpl
                    model.getUpComingMoviesById(id).observe(activity, Observer {
                        mView.displayUpComingData(it)
                        val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
                        {
                            mView.displaySimilarMovieError(it)
                        }
                            .observeForever{mView.displaySimilarMovies(it)}

                    })
//                    val movieVo = model.getUpComingMoviesById(id)
//                        .observeForever {
//                            mView.displayUpComingData(it)
//                            val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
//                            {
//                                mView.displaySimilarMovieError(it)
//                            }
//                            mView.displaySimilarMovies(list)
//                        }
                }
                CASE_SEARCH -> {

                    val model = SearchMovieModelImpl
                    model.searchMovieById(id).observe(activity, Observer {
                        mView.displaySearchMovieData(it)
                        val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
                        {
                            mView.displaySimilarMovieError(it)
                        }
                            .observeForever{mView.displaySimilarMovies(it)}

                    })
//                    val movieVo = model.searchMovieById(id)
//                        .observeForever {
//                            mView.displaySearchMovieData(it)
//                            val list = SimilarMovieModelImpl.getSimmilarMovie(it.id)
//                            {
//                                mView.displaySimilarMovieError(it)
//                            }
//                            mView.displaySimilarMovies(list)
//                        }
                }
            }

        }
    }
}