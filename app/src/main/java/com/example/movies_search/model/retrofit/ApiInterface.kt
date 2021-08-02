package com.example.movies_search.model.retrofit

import com.example.movies_search.model.Search
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

//URL to build: https://movie-database-imdb-alternative.p.rapidapi.com/?rapidapi-key={{}}&s={{search}}&page=1&r=json


interface ApiInterface {
    @GET("?")
    fun getSearch(
        @Query("api_key") apiKey: String?,
        @Query("query") movieName: String?
    ): Observable<Search?>?

}