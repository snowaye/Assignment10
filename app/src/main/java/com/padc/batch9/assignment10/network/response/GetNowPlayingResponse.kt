package com.padc.batch9.assignment10.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo

class GetNowPlayingResponse (
    @SerializedName("results")
    val data: List<NowPlayingMovieVo>?) {
}