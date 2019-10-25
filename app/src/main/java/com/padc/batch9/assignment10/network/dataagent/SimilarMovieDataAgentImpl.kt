package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.SimilarMovieVo
import com.padc.batch9.assignment10.network.response.GetSimilarMovieResponse
import com.padc.batch9.assignment10.util.EM_NULL_SIMILAR_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object SimilarMovieDataAgentImpl: BaseDataAgent(), SimilarMovieDataAgent {
    override fun getSimilarMovies(
        id: Int,
        onSuccess: (List<SimilarMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getSimilarMovie(id)
        call.enqueue(object : Callback<GetSimilarMovieResponse> {
            override fun onFailure(call: Call<GetSimilarMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetSimilarMovieResponse>,
                response: Response<GetSimilarMovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)
                    } else {
                        onFailure(EM_NULL_SIMILAR_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_SIMILAR_RESPONSE)
                }
            }

        })
    }
}

