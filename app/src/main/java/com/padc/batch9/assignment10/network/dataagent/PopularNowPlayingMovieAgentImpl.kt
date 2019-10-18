package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.network.response.GetPopularResponse
import com.padc.batch9.assignment10.util.EM_NULL_POPULAR_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PopularNowPlayingMovieAgentImpl: BaseDataAgent(), PopularMovieDataAgent {
    override fun getPopularMovies(
        onSuccess: (List<PopularMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getPopularMovie()

        call.enqueue(object  : Callback<GetPopularResponse> {

            override fun onFailure(call: Call<GetPopularResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetPopularResponse>,
                response: Response<GetPopularResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)
                    } else {
                        onFailure(EM_NULL_POPULAR_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_POPULAR_RESPONSE)
                }
            }
        })
    }

}