package com.padc.batch9.assignment10.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.activity.BaseActivity
import com.padc.batch9.assignment10.activity.MovieDetailActivity
import com.padc.batch9.assignment10.adapter.NowPlayingAdapter
import com.padc.batch9.assignment10.adapter.PopularAdapter
import com.padc.batch9.assignment10.adapter.TopRatedAdapter
import com.padc.batch9.assignment10.adapter.UpComingAdapter
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo
import com.padc.batch9.assignment10.mvp.presenter.HomePresenter
import com.padc.batch9.assignment10.mvp.view.HomeMovieListView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(), HomeMovieListView {
    override fun navigateToDetail(id: Int, from: String) {
        startActivity(context?.let { MovieDetailActivity.newIntent(it, id, from) })
    }

    override fun displayNowPlyingList(lit: List<NowPlayingMovieVo>) {
        Log.i("HomeFrag", "lit=="+lit.size)
        mNowPlayingAdapter.setNewData(lit.toMutableList())
    }

    override fun displayTopRateList(lit: List<TopRatedMovieVo>) {
        mTopRatedAdapter.setNewData(lit.toMutableList())
    }

    override fun displayPopularList(lit: List<PopularMovieVo>) {
        mPopularAdapter.setNewData(lit.toMutableList())
    }

    override fun displayUpComingList(lit: List<UpComingMovieVo>) {
        mUpComingAdapter.setNewData(lit.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private lateinit var mPresenter: HomePresenter
    private lateinit var mNowPlayingAdapter: NowPlayingAdapter
    private lateinit var mTopRatedAdapter: TopRatedAdapter
    private lateinit var mUpComingAdapter: UpComingAdapter
    private lateinit var mPopularAdapter: PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        mPresenter = ViewModelProviders.of(this).get(HomePresenter::class.java)
        mPresenter.initPresenter(this)
        mNowPlayingAdapter = NowPlayingAdapter(mPresenter)
        mTopRatedAdapter = TopRatedAdapter(mPresenter)
        mPopularAdapter = PopularAdapter(mPresenter)
        mUpComingAdapter = UpComingAdapter(mPresenter)

        val recvNowPlaying = root.findViewById<RecyclerView>(R.id.recv_now_playing)
        val recvPopular = root.findViewById<RecyclerView>(R.id.recv_popular)
        val recvTopRated = root.findViewById<RecyclerView>(R.id.recv_top_rated)
        val recvUpComing = root.findViewById<RecyclerView>(R.id.recv_coming_soon)
        recvNowPlaying.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recvTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recvUpComing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recvNowPlaying.adapter = mNowPlayingAdapter
        recvPopular.adapter= mPopularAdapter
        recvTopRated.adapter = mTopRatedAdapter
        recvUpComing.adapter = mUpComingAdapter

        mPresenter.onUIReady(activity as BaseActivity)
        return root
    }
}