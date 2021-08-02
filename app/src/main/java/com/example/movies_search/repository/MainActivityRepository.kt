package com.example.movies_search.repository

import android.util.Log
import com.example.movies_search.model.Search
import com.example.movies_search.model.retrofit.ApiInterface
import io.reactivex.Observable

class MainActivityRepository(private val apiInterface: ApiInterface) {

    fun getSearch(apiKey: String, movie: String): Observable<Search?>? {
        return apiInterface.getSearch(apiKey, movie)
            ?.doOnNext {
                Log.d("getCryptoData", "Dispatching ${it?.imdbID} ID data from API...")
            }
    }
}