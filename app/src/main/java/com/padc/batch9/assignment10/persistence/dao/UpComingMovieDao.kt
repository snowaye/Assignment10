package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.UpComingMovieVo

@Dao
abstract class UpComingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUpComingMovies(events: List<UpComingMovieVo>) : LongArray

    @Query("select * from upcoming_movie")
    abstract fun getAllUpComingMovies(): LiveData<List<UpComingMovieVo>>

    @Query("select * from upcoming_movie where id= :id")
    abstract fun getUpComingMovieById(id: Int): LiveData<UpComingMovieVo>
}