package com.padc.batch9.assignment10.worker

import android.content.Context
import androidx.work.WorkerParameters


class TopRatedMovieWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams)
{
    override fun doWork(): Result {
        var result:Result = Result.failure()

        topRatedDataAgentNowPlaying.getTopRatedMovies(
                        {
                database.topRatedDao().insertTopRatedMovies(it)
                result = Result.success()
            },
            {
                result = Result.failure()
            }
        )
        return result
    }
}