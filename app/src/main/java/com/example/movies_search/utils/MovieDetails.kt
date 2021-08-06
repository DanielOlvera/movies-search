package com.example.movies_search.utils

import android.content.Intent


data class MovieDetails(
    var title: String? = null,
    var year: String? = null,
    var imdbID: String? = null,
    var type: String? = null,
    var posterPath: String? = null,
) {


    fun fromExtras(details: Intent): MovieDetails {
        title = details.getStringExtra(MoviesConstants.MOVIE_TITLE_EXTRA)
        year = retrieveDate(details.getStringExtra(MoviesConstants.MOVIE_YEAR_EXTRA))
        imdbID = details.getStringExtra(MoviesConstants.MOVIE_IMDB_ID_EXTRA)
        type = details.getStringExtra(MoviesConstants.MOVIE_TYPE_EXTRA)
        posterPath = details.getStringExtra(MoviesConstants.MOVIE_POSTER_EXTRA)
        return this
    }

    private fun retrieveDate(date: String?): String? {
        return if (date!!.isNotEmpty()) {
            date.substring(0, 4)
        } else {
            date
        }
    }
}