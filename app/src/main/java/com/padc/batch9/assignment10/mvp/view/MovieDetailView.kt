package com.padc.batch9.assignment10.mvp.view

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.*

interface MovieDetailView: BaseView {

    fun displayNowPlayingData(movieVo:NowPlayingMovieVo)

    fun displalyPopularData(movieVo:PopularMovieVo)

    fun displayTopRatedData(movieVo:TopRatedMovieVo)

    fun displayUpComingData(movieVo:UpComingMovieVo)

    fun displaySearchMovieData(movieVo: SearchMovieVo)

    fun displaySimilarMovies(similarMovieList: List<SimilarMovieVo>)

    fun displaySimilarMovieError(message:String)

}