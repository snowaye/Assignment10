package com.padc.batch9.assignment10.mvp.view

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

interface MovieDetailView: BaseView {

    fun displayNowPlayingData(movieVo:NowPlayingMovieVo)

    fun displalyPopularData(movieVo:PopularMovieVo)

    fun displayTopRatedData(movieVo:TopRatedMovieVo)

    fun displayUpComingData(movieVo:UpComingMovieVo)
}