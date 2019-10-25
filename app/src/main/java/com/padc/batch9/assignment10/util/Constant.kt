package com.padc.batch9.assignment10.util

const val MOVIE_DB = "moviedb"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
const val API_KEY = "e5c213a30cee4103f16bee2fbe901f03"
const val LANGUAGE = "en-US"
const val PAGE = 1
const val GET_NOW_PLAYING = "movie/now_playing"
const val GET_TOP_RATED = "movie/top_rated"
const val GET_POPULAR = "movie/popular"
const val GET_UPCOMING = "movie/upcoming"
const val SEARCH_MOVIE = "search/movie"
const val GET_SIMILAR_MOVIE = "movie/{id}/similar"

const val EM_NULL_NOW_PLAYING_RESPONSE = "Null returned for now playing movie list!"
const val EM_NULL_POPULAR_RESPONSE = "Null returned for now popular movie list!"
const val EM_NULL_TOP_RATED_RESPONSE = "Null returned for top rated movie list!"
const val EM_NULL_SIMILAR_RESPONSE = "Null returned for similar movie list!"
const val EM_NULL_UPCOMING_RESPONSE = "Null returned for upcoming movie list!"

const val EM_NULL_SEARCH_RESPONSE = "Sorry, there's no such movie that matches with your search!"

const val CASE_NOW_PLAYING = "now_playing"
const val CASE_POPULAR = "popular"
const val CASE_TOP_RATED = "top_rated"
const val CASE_UPCOMING = "upcoming"
const val CASE_SEARCH = "search"
const val CASE_SIMILAR = "similar"