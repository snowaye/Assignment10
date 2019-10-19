package com.padc.batch9.assignment10.mvp.view

import com.padc.batch9.assignment10.data.vo.SearchMovieVo

interface SearchMovieView:BaseView{

    fun displaySearchResult(list:List<SearchMovieVo>)

    fun showProgressBar()

    fun hideProgressBar()

    fun displayError(message:String)

    fun navigateToDetail(id:Int, from:String)
}