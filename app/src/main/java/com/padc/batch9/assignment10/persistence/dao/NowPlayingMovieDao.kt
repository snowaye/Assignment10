package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo

@Dao
abstract class NowPlayingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertNowPlalyingMovies(events: List<NowPlayingMovieVo>) : LongArray

    @Query("select * from now_playing_movie")
    abstract fun getAllNowPlayingMovies(): LiveData<List<NowPlayingMovieVo>>

    @Query("select * from now_playing_movie where id= :id")
    abstract fun getNowPlayingMovieById(id: Int): LiveData<NowPlayingMovieVo>
}