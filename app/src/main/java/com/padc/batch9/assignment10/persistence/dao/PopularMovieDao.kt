package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.PopularMovieVo

@Dao
abstract class PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPoppularMovies(events: List<PopularMovieVo>) : LongArray

    @Query("select * from popular_movie")
    abstract fun getAllPopularMovies(): LiveData<List<PopularMovieVo>>

    @Query("select * from popular_movie where id= :id")
    abstract fun getPoularMovieById(id: Int): LiveData<PopularMovieVo>
}