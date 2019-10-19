package com.padc.batch9.assignment10.mvp.view

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

interface HomeMovieListView: BaseView{

    fun displayNowPlyingList(lit:List<NowPlayingMovieVo>)

    fun displayTopRateList(lit:List<TopRatedMovieVo>)

    fun displayPopularList(lit:List<PopularMovieVo>)

    fun displayUpComingList(lit:List<UpComingMovieVo>)

    fun displayError(errorMessage:String)

    fun navigateToDetail(id:Int, from:String)
}