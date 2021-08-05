package com.example.movies_search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies_search.model.Search
import com.example.movies_search.repository.MainActivityRepository

class SearchMoviesViewModel : ViewModel() {
    var searchLiveData: MutableLiveData<List<Search>>? = null

    fun getSearch(apiKey: String, movie: String) : LiveData<List<Search>>? {
        searchLiveData = MainActivityRepository.getSearchApiCallList(apiKey, movie)

        return searchLiveData
    }
}