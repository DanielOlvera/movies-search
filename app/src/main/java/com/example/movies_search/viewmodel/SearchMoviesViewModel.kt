package com.example.movies_search.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies_search.model.Search
import com.example.movies_search.repository.MainActivityRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

const val TAG = "SearchMoviesViewModel"
class SearchMoviesViewModel(private val repository: MainActivityRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var searchMovie = MutableLiveData<Search>()

    internal fun getSearch(apiKey: String, movie: String) {
        val disposable = repository.getSearch(apiKey, movie)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeWith(object : DisposableObserver<Search>() {
                override fun onNext(t: Search) {
                    Log.d(TAG, "What we got for $t")
                    searchMovie.value = t
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, e.printStackTrace().toString())
                }

                override fun onComplete() {}

            })

    }

    override fun onCleared() {
        Log.d("GithubActivityViewModel", "onCleared()")
        compositeDisposable.dispose()
        super.onCleared()

    }


}