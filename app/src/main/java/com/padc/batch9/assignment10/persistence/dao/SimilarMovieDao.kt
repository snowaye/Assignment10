package com.padc.batch9.assignment10.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment10.data.vo.NowPlayingMovieVo
import com.padc.batch9.assignment10.data.vo.SimilarMovieVo

@Dao
abstract class SimilarMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSimilarMovies(movies: List<SimilarMovieVo>) : LongArray

    @Query("select * from now_playing_movie")
    abstract fun getAllSimilarMovies(): LiveData<List<SimilarMovieVo>>

    @Query("select * from now_playing_movie where id= :id")
    abstract fun getSimilarMovieById(id: Int): LiveData<SimilarMovieVo>
}