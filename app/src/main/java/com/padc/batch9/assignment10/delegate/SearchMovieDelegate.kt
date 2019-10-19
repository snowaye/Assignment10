package com.padc.batch9.assignment10.delegate

import com.padc.batch9.assignment10.activity.BaseActivity

interface SearchMovieDelegate {
    fun onSearchQuryTypeAfter(query:String, activity:BaseActivity)
}