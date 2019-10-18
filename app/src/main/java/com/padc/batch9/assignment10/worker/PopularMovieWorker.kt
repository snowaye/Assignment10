package com.padc.batch9.assignment10.worker

import android.content.Context
import androidx.work.WorkerParameters


class PopularMovieWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams)
{
    override fun doWork(): Result {
        var result:Result = Result.failure()

        popularDataAgentNowPlaying.getPopularMovies(
                        {
                database.popularDao().insertPoppularMovies(it)
                result = Result.success()
            },
            {
                result = Result.failure()
            }
        )
        return result
    }
}