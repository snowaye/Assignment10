package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo
import com.padc.batch9.assignment10.network.response.GetTopRatedResponse
import com.padc.batch9.assignment10.util.EM_NULL_TOP_RATED_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TopRatedNowPlayingMovieAgentImpl: BaseDataAgent(), TopRatedMovieDataAgent {
    override fun getTopRatedMovies(
        onSuccess: (List<TopRatedMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getTopRatedMovie()

        call.enqueue(object  : Callback<GetTopRatedResponse> {

            override fun onFailure(call: Call<GetTopRatedResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetTopRatedResponse>,
                response: Response<GetTopRatedResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)
                    } else {
                        onFailure(EM_NULL_TOP_RATED_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_TOP_RATED_RESPONSE)
                }
            }
        })
    }

}