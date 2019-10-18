package com.padc.batch9.assignment10.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo

class GetTopRatedResponse (
    @SerializedName("results")
    val data: List<TopRatedMovieVo>?) {
}