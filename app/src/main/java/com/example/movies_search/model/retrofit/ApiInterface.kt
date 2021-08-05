package com.example.movies_search.model.retrofit

import com.example.movies_search.model.Base
import com.example.movies_search.model.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//URL to build: https://movie-database-imdb-alternative.p.rapidapi.com/?rapidapi-key={{}}&s={{search}}&page=1&r=json


interface ApiInterface {

    @GET("?")
    fun getSearch(
        @Query("rapidapi-key") apiKey: String?,
        @Query("s") movieName: String
    ): Call<Base>?

}