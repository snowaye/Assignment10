package com.padc.batch9.assignment10.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

class GetUpComingResponse (
//    "page": 1,
//    "total_results": 10000,
//"total_pages": 500,
    @SerializedName("results")
    val data: List<UpComingMovieVo>?) {
}