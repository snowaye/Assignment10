package com.padc.batch9.assignment10.network.dataagent

import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.network.response.GetNowPlayingResponse
import com.padc.batch9.assignment10.util.EM_NULL_NOW_PLAYING_RESPONSE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NowPlayingNowPlayingMovieAgentImpl: BaseDataAgent(), NowPlayingMovieDataAgent {
    override fun getNowPlayingMovies(
        onSuccess: (List<NowPlayingMovieVo>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = movieApi.getNowPlayingMovie()

        call.enqueue(object  : Callback<GetNowPlayingResponse> {

            override fun onFailure(call: Call<GetNowPlayingResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetNowPlayingResponse>,
                response: Response<GetNowPlayingResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null) {
                    if (movieResponse.data != null) {
                        onSuccess(movieResponse.data)
                    } else {
                        onFailure(EM_NULL_NOW_PLAYING_RESPONSE)
                    }
                } else {
                    onFailure(EM_NULL_NOW_PLAYING_RESPONSE)
                }
            }
        })
    }

//    private val movieApi:MovieApi
//
//    init {
//        val okHttpClient = OkHttpClient.Builder()
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
//            .writeTimeout(15, TimeUnit.SECONDS)
//            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        movieApi = retrofit.create(MovieApi::class.java)
//    }


}