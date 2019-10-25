package com.padc.batch9.assignment10.data.model


import androidx.lifecycle.LiveData
import com.padc.batch9.assignment10.data.vo.SearchMovieVo

interface SearchMovieModel {

    fun searchMovie(
        query:String,
        onFailure:(String) -> Unit):LiveData<List<SearchMovieVo>>

    fun  searchMovieById(id:Int):LiveData<SearchMovieVo>
}