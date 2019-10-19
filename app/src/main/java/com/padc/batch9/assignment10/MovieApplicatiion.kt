package com.padc.batch9.assignment10

import android.app.Application
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.padc.batch9.assignment10.data.model.*
import com.padc.batch9.assignment10.worker.NowPlayingWorker
import com.padc.batch9.assignment10.worker.PopularMovieWorker
import com.padc.batch9.assignment10.worker.TopRatedMovieWorker
import com.padc.batch9.assignment10.worker.UpComingMovieWorker

class MovieApplicatiion: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("Movieapplication", "onCreate")
       NowPlayingMovieModelImpl.initDatabase(applicationContext)
        TopRatedMovieModelImpl.initDatabase(applicationContext)
        UpComingMovieModelImpl.initDatabase(applicationContext)
        PopularMovieModelImpl.initDatabase(applicationContext)

        getNowPlayingOneTime()
        getPopulrOneTime()
        getTopRatedOneTime()
        getUpComingOneTime()
    }

    private fun getNowPlayingOneTime() {
        val getEventWorkRequest = OneTimeWorkRequest
            .Builder(NowPlayingWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventWorkRequest)
    }

    private fun getUpComingOneTime() {
        val getEventWorkRequest = OneTimeWorkRequest
            .Builder(UpComingMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventWorkRequest)
    }

    private fun getPopulrOneTime() {
        val getEventWorkRequest = OneTimeWorkRequest
            .Builder(PopularMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventWorkRequest)
    }

    private fun getTopRatedOneTime() {
        val getEventWorkRequest = OneTimeWorkRequest
            .Builder(TopRatedMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventWorkRequest)
    }
}