package com.padc.batch9.assignment10.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padc.batch9.assignment10.data.vo.*
import com.padc.batch9.assignment10.persistence.dao.*
import com.padc.batch9.assignment10.persistence.typeconverter.StringTypeConverter
import com.padc.batch9.assignment10.util.MOVIE_DB

@Database(entities = arrayOf(NowPlayingMovieVo::class, PopularMovieVo::class,
    TopRatedMovieVo::class, UpComingMovieVo::class, SearchMovieVo::class,
    SimilarMovieVo::class),version = 4, exportSchema = false)
@TypeConverters(StringTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun nowPlayingDao():NowPlayingMovieDao

    abstract fun topRatedDao():TopRatedMovieDao

    abstract fun popularDao():PopularMovieDao

    abstract fun upComingDao():UpComingMovieDao

    abstract fun searchMovieDao():SearchMovieDao

    abstract fun similarMovieDao():SimilarMovieDao

    companion object{
        private var instance : MovieDatabase?= null
        fun getInstance(context: Context):MovieDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context, MovieDatabase::class.java, MOVIE_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }
}