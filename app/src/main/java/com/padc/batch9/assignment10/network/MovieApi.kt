package com.padc.batch9.assignment10.network

import com.padc.batch9.assignment10.network.response.GetUpComingResponse
import com.padc.batch9.assignment10.network.response.GetNowPlayingResponse
import com.padc.batch9.assignment10.network.response.GetPopularResponse
import com.padc.batch9.assignment10.network.response.GetTopRatedResponse
import com.padc.batch9.assignment10.util.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET(GET_NOW_PLAYING)
    fun  getNowPlayingMovie(
        @Query("api_key") key:String= API_KEY,
        @Query("language") language:String= LANGUAGE,
        @Query("page") page:Int = PAGE
    ): Call<GetNowPlayingResponse>

    @GET(GET_POPULAR)
    fun  getPopularMovie(
        @Query("api_key") key:String= API_KEY,
        @Query("language") language:String= LANGUAGE,
        @Query("page") page:Int = PAGE
    ): Call<GetPopularResponse>

    @GET(GET_TOP_RATED)
    fun  getTopRatedMovie(
        @Query("api_key") key:String= API_KEY,
        @Query("language") language:String= LANGUAGE,
        @Query("page") page:Int = PAGE
    ): Call<GetTopRatedResponse>

    @GET(GET_UPCOMING)
    fun  getUpComingMovie(
        @Query("api_key") key:String= API_KEY,
        @Query("language") language:String= LANGUAGE,
        @Query("page") page:Int = PAGE
    ): Call<GetUpComingResponse>
}