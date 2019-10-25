package com.padc.batch9.assignment10.mvp.presenter

import androidx.lifecycle.Observer
import com.padc.batch9.assignment10.activity.BaseActivity
import com.padc.batch9.assignment10.data.model.SearchMovieModelImpl
import com.padc.batch9.assignment10.delegate.MovieItemDelegate
import com.padc.batch9.assignment10.delegate.SearchMovieDelegate
import com.padc.batch9.assignment10.mvp.view.SearchMovieView

class SearchPresenter: BasePresenter<SearchMovieView>(), MovieItemDelegate {
    override fun onTapMovieItemDelegate(id: Int, from: String) {
        mView.navigateToDetail(id, from)
    }


    fun onEditTextTextChange (search:String, activity:BaseActivity) {
        mView.showProgressBar()
        val searchViewModel = SearchMovieModelImpl
        searchViewModel.searchMovie(search) {
            mView.displayError(it)
        }.observe(activity, Observer { mView.displaySearchResult(it) })
        mView.hideProgressBar()
    }



}