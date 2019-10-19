package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.SearchMovieVo
import com.padc.batch9.assignment10.network.response.GetSearchMovieResponse
import com.padc.batch9.assignment10.util.EM_NULL_SEARCH_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object SearchMovieDataAgentImpl:BaseDataAgent(), SearchMovieDataAgent {

    override fun searchMovie(
        query: String,
        onSuccess: (List<SearchMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.searchMovie(query = query)

        call.enqueue(object : Callback<GetSearchMovieResponse> {
            override fun onFailure(call: Call<GetSearchMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetSearchMovieResponse>,
                response: Response<GetSearchMovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse!=null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)

                    } else {
                        onFailure(EM_NULL_SEARCH_RESPONSE)
                    }
                }
                else {
                    onFailure(EM_NULL_SEARCH_RESPONSE)

                }
            }

        })

    }


}
