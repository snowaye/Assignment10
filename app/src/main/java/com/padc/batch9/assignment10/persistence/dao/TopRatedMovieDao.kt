package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo
import com.padc.batch9.assignment10.data.vo.TopRatedMovieVo

@Dao
abstract class TopRatedMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTopRatedMovies(events: List<TopRatedMovieVo>) : LongArray

    @Query("select * from top_rated_movie")
    abstract fun getAllTopRatedMovies(): LiveData<List<TopRatedMovieVo>>

    @Query("select * from top_rated_movie where id= :id")
    abstract fun getTopRatedMovieById(id: Int): LiveData<TopRatedMovieVo>
}