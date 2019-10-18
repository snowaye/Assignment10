package com.padc.batch9.assignment10.worker

import android.content.Context
import androidx.work.WorkerParameters


class UpComingMovieWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams)
{
    override fun doWork(): Result {
        var result:Result = Result.failure()

        upComingDataAgentNowPlaying.getUpcomingMovies(
                        {
                database.upComingDao().insertUpComingMovies(it)
                result = Result.success()
            },
            {
                result = Result.failure()
            }
        )
        return result
    }
}