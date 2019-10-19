package com.padc.batch9.assignment10.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import coil.api.load
import com.padc.batch9.assignment10.R
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo
import com.padc.batch9.assignment10.mvp.presenter.DetailPresenter
import com.padc.batch9.assignment10.mvp.view.MovieDetailView
import com.padc.batch9.assignment10.util.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity(), MovieDetailView {

    private lateinit var mPresenter:DetailPresenter

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


        val id = intent.getIntExtra(IE_EVENT_ID, 0)
        val from = intent.getStringExtra(IE_FROM)

        mPresenter.onUIReady(id, from)
    }

}
