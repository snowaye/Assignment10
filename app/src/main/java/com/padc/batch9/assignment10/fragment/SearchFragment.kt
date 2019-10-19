package com.padc.batch9.assignment10.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.activity.MovieDetailActivity
import com.padc.batch9.assignment10.adapter.SearchMovieAdapter
import com.padc.batch9.assignment10.data.vo.SearchMovieVo
import com.padc.batch9.assignment10.mvp.presenter.SearchPresenter
import com.padc.batch9.assignment10.mvp.view.SearchMovieView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment :Fragment(), SearchMovieView{
    override fun navigateToDetail(id: Int, from: String) {
        startActivity(context?.let { MovieDetailActivity.newIntent(it, id, from) })
    }

    override fun displaySearchResult(list: List<SearchMovieVo>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun showProgressBar() {
        progressbar.visibility = View.VISIBLE

    }

    override fun hideProgressBar() {
        progressbar.visibility = View.GONE
    }

    override fun displayError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }

    private lateinit var mPresenter:SearchPresenter
    private lateinit var mAdapter:SearchMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)
        mPresenter = ViewModelProviders.of(this).get(SearchPresenter::class.java)
        mPresenter.initPresenter(this)
        mAdapter = SearchMovieAdapter(mPresenter)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        recyclerView.adapter = mAdapter
        return rootView
    }
}