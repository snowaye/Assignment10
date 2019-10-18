package com.padc.batch9.assignment10.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movie")
class PopularMovieVo(

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,

    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    val voteCount: Int,

    @ColumnInfo(name = "video")
    @SerializedName("video")
    val video: Boolean,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val posterPath: String,

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    val adult: Boolean,

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backDropPath: String,

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val originalLanguage: String,

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val originalTitle: String,

    @ColumnInfo(name = "genre_ids")
    @SerializedName("genre_ids")
    val genreList: List<String>,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate: String

) {
}