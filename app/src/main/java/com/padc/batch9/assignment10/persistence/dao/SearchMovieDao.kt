package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.SearchMovieVo

@Dao
abstract class SearchMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSearchMovies(movies: List<SearchMovieVo>) : LongArray

    @Query("select * from search_movie")
    abstract fun getAllSearchMovies(): LiveData<List<SearchMovieVo>>

    @Query("select * from search_movie where id= :id")
    abstract fun getSearchMovieById(id: Int): LiveData<SearchMovieVo>
}