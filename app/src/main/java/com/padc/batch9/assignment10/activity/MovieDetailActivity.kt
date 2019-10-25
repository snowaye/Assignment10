package com.padc.batch9.assignment10.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.adapter.SimilarMoviedapter
import com.padc.batch9.assignment10.data.vo.*
import com.padc.batch9.assignment10.mvp.presenter.DetailPresenter
import com.padc.batch9.assignment10.mvp.view.MovieDetailView
import com.padc.batch9.assignment10.util.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.fragment_home.*

class MovieDetailActivity : BaseActivity(), MovieDetailView {
    override fun displaySimilarMovies(similarMovieList: List<SimilarMovieVo>) {
        mAdapter.setNewData(similarMovieList.toMutableList())
    }


    override fun displaySearchMovieData(movieVo: SearchMovieVo) {
        movieTitle.text = movieVo.title.toString()
        overview.text = movieVo.overview.toString()
        releaseDate.text = movieVo.releaseDate.toString()            
        imgv_poster.load(
            IMAGE_BASE_URL +movieVo.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }


    override fun displaySimilarMovieError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }

    private lateinit var mPresenter:DetailPresenter
    private lateinit var mAdapter: SimilarMoviedapter

    companion object {
        const val IE_EVENT_ID = "id"
        const val IE_FROM = "from"

        fun newIntent(context: Context, id:Int, from:String): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(IE_EVENT_ID, id)
                putExtra(IE_FROM, from)
            }
        }
    }


    override fun displayNowPlayingData(movieVo: NowPlayingMovieVo) {
        movieTitle.text = movieVo.title.toString()
        overview.text = movieVo.overview.toString()
        releaseDate.text = movieVo.releaseDate.toString()
        imgv_poster.load(
            IMAGE_BASE_URL +movieVo.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }

    override fun displalyPopularData(movieVo: PopularMovieVo) {
        movieTitle.text = movieVo.title.toString()
        overview.text = movieVo.overview.toString()
        releaseDate.text = movieVo.releaseDate.toString()
        imgv_poster.load(
            IMAGE_BASE_URL +movieVo.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }

    override fun displayTopRatedData(movieVo: TopRatedMovieVo) {
        movieTitle.text = movieVo.title.toString()
        overview.text = movieVo.overview.toString()
        releaseDate.text = movieVo.releaseDate.toString()
        imgv_poster.load(
            IMAGE_BASE_URL +movieVo.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }

    override fun displayUpComingData(movieVo: UpComingMovieVo) {
        movieTitle.text = movieVo.title.toString()
        overview.text = movieVo.overview.toString()
        releaseDate.text = movieVo.releaseDate.toString()
        imgv_poster.load(
            IMAGE_BASE_URL +movieVo.posterPath
        )
        {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.ic_placeholder_moviie)
            error(R.drawable.ic_placeholder_moviie)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        mPresenter = DetailPresenter()
        mPresenter.initPresenter(this)

        mAdapter = SimilarMoviedapter(mPresenter)

        val id = intent.getIntExtra(IE_EVENT_ID, 0)
        val from = intent.getStringExtra(IE_FROM)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = mAdapter

        mPresenter.onUIReady(id, from, this)
    }

}
