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
import retrofit2.Response


class SearchMoviesViewModel(private val repository: MainActivityRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var searchMovie = MutableLiveData<Search>()

    internal fun getSearch(apiKey: String, movie: String) {
        val disposable = repository.getSearch(apiKey, movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<Response<Search>>() {
                override fun onNext(response: Response<Search>) {
                    searchMovie.value = response.body()
                }

                override fun onComplete() {}

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })

    }

    override fun onCleared() {
        Log.d("GithubActivityViewModel", "onCleared()")
        compositeDisposable.dispose()
        super.onCleared()

    }


}