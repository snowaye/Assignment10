package com.padc.batch9.assignment10.worker

import android.content.Context
import androidx.work.WorkerParameters


class NowPlayingWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams)
{
    override fun doWork(): Result {
        var result:Result = Result.failure()

        nowPlayingDataAgentNowPlaying.getNowPlayingMovies(
                        {
                database.nowPlayingDao().insertNowPlalyingMovies(it)
                result = Result.success()
            },
            {
                result = Result.failure()
            }
        )
        return result
    }
}