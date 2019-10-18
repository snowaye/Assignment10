package com.padc.batch9.assignment10.network.dataagent


import com.padc.batch9.assignment10.data.vo.UpComingMovieVo
import com.padc.batch9.assignment10.network.response.GetUpComingResponse
import com.padc.batch9.assignment10.util.EM_NULL_UPCOMING_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UpComingNowPlayingMovieAgentImpl: BaseDataAgent(), UpComingMovieDataAgent {
    override fun getUpcomingMovies(
        onSuccess: (List<UpComingMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getUpComingMovie()

        call.enqueue(object  : Callback<GetUpComingResponse> {

            override fun onFailure(call: Call<GetUpComingResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetUpComingResponse>,
                response: Response<GetUpComingResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)
                    } else {
                        onFailure(EM_NULL_UPCOMING_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_UPCOMING_RESPONSE)
                }
            }
        })
    }


}